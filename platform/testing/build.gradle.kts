plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {

    namespace = "com.orogersilva.scaffoldandroid.testing"

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

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(project(":platform:core:networking"))

    api(platform(libs.android.compose.billOfMaterials))

    api(libs.android.activity.activityCompose)
    api(libs.android.test.compose)
    implementation(libs.android.test.runner)

    implementation(libs.dagger.hilt.testing)
    implementation(libs.junit.core)
    api(libs.kotlin.test)
    implementation(libs.okhttp.core)
    implementation(libs.okhttp.loggingInterceptor)
    api(libs.okhttp.mockWebServer)
    api(libs.turbine.core)
}