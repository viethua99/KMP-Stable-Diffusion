plugins {
    id("brushai.android.application")
    id("brushai.android.application.compose")
    id("brushai.android.hilt")
}

android {
    namespace = "com.vproject.brushai"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.vproject.brushai"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.vproject.brushai.core.testing.BrushAiTestRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {

    implementation(project(":feature:generate"))

    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))

    androidTestImplementation(project(":core:testing"))

    debugImplementation(project(":ui-test-hilt-manifest"))

    // Jetpack Compose Standard Dependencies
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material.windowSizeClass)
    implementation(libs.accompanist.systemuicontroller)

    // Android Kotlin Extension Dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(platform(libs.kotlin.bom))
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.hilt.navigation.compose)

    // UI Testing Dependencies
    androidTestImplementation (libs.androidx.test.ext.ktx)
    androidTestImplementation (libs.androidx.test.espresso.core)
    androidTestImplementation (libs.androidx.compose.ui.test.junit)
    androidTestImplementation(libs.accompanist.testharness)


    implementation(libs.junit4)
}