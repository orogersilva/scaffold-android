plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.ksp)
}

android {

    namespace = "com.orogersilva.scaffoldandroid.data"

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

    implementation(project(":platform:core:ui"))

    api(libs.moshi.core)
    ksp(libs.moshi.kotlincodegen)
    implementation(libs.timber.core)

    testImplementation(libs.junit.core)
    testImplementation(libs.kotlin.test)

    androidTestImplementation(project(":platform:testing"))

    androidTestImplementation(libs.junit.core)
    androidTestImplementation(libs.junit.ext)
    androidTestImplementation(libs.kotlin.test)
}