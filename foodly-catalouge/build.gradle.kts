plugins {
    id("foodly.android.application")
    id("foodly.android.application.compose")
}

android {
    namespace = "me.sankalpchauhan.foodly_catalouge"

    defaultConfig {
        applicationId = "me.sankalpchauhan.foodly_catalouge"
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:ui"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.accompanist.flowlayout)
}