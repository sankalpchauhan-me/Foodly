import java.util.Properties
import java.io.FileInputStream

val debugKeystorePropertiesFile = rootProject.file("debugkeystore.properties")
val debugKeystoreProperties = Properties()
debugKeystoreProperties.load(FileInputStream(debugKeystorePropertiesFile))

val releaseKeystorePropertiesFile = rootProject.file("releasekeystore.properties")
val releaseKeystoreProperties = Properties()
releaseKeystoreProperties.load(FileInputStream(releaseKeystorePropertiesFile))

plugins {
    val buildLogicSuffix = "foodly"
    id("${buildLogicSuffix}.android.application")
    id("${buildLogicSuffix}.android.application.compose")
    id("${buildLogicSuffix}.android.hilt")
    id("jacoco")
    id("${buildLogicSuffix}.firebase-perf")
}

android {
    namespace = "me.sankalpchauhan.foodly"
    defaultConfig {
        applicationId = "me.sankalpchauhan.foodly"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    signingConfigs{
        getByName("debug"){
            keyAlias = debugKeystoreProperties["keyAlias"] as String
            keyPassword = debugKeystoreProperties["keyPassword"] as String
            storeFile = file(debugKeystoreProperties["storeFile"]!!)
            storePassword = debugKeystoreProperties["storePassword"] as String
        }
        create("release"){
            keyAlias = releaseKeystoreProperties["keyAlias"] as String
            keyPassword = releaseKeystoreProperties["keyPassword"] as String
            storeFile = file(releaseKeystoreProperties["storeFile"]!!)
            storePassword = releaseKeystoreProperties["storePassword"] as String
        }
    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
        val release by getting {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
            isDebuggable = false
        }
        val benchmark by creating {
            // Enable all the optimizations from release build through initWith(release).
            initWith(release)
            matchingFallbacks.add("release")
            // Debug key signing is available to everyone.
            signingConfig = signingConfigs.getByName("debug")
            // Only use benchmark proguard rules
            proguardFiles("benchmark-rules.pro")
            //  FIXME enabling minification breaks access to demo backend.
            isMinifyEnabled = false
            applicationIdSuffix = ".benchmark"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    buildFeatures {
        compose=true
    }
    composeOptions {
        kotlinCompilerExtensionVersion=  "1.3.2"
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.0")
    androidTestImplementation(libs.androidx.navigation.testing)
    debugImplementation(libs.androidx.compose.ui.testManifest)
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.window.manager)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)
    implementation(libs.androidx.compose.material3)
    debugImplementation(libs.androidx.compose.ui.tooling.preview)
}

// androidx.test is forcing JUnit, 4.12. This forces it to use 4.13
configurations.configureEach {
    resolutionStrategy {
        force(libs.junit4)
        // Temporary workaround for https://issuetracker.google.com/174733673
        force("org.objenesis:objenesis:2.6")
    }
}