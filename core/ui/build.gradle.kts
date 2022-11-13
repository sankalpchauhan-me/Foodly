plugins {
    id("foodly.android.library")
    id("foodly.android.library.compose")
    id("foodly.android.library.jacoco")
}

android {
    namespace = "me.sankalpchauhan.ui"
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(libs.androidx.activity.compose)
    implementation(libs.accompanist.flowlayout)
}