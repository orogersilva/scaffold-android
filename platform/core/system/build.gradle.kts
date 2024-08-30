plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {

    namespace = "com.orogersilva.scaffoldandroid.system"

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

    implementation(libs.android.ktx.core)

    implementation(libs.timber.core)
}