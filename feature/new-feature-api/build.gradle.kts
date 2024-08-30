plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {

    namespace = "com.orogersilva.scaffoldandroid.newfeatureapi"

    compileSdk = rootProject.extra["compileSdk"] as Int

    defaultConfig {

        minSdk = rootProject.extra["minSdk"] as Int

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    api(project(":platform:core:feature-api"))
    api(project(":platform:core:networking"))
    api(project(":platform:core:system"))
    api(project(":platform:core:ui"))

    implementation(libs.kotlin.serialization.json)
}