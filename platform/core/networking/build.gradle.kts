plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.ksp)
    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {

    namespace = "com.orogersilva.scaffoldandroid.networking"

    compileSdk = rootProject.extra["compileSdk"] as Int

    defaultConfig {

        minSdk = rootProject.extra["minSdk"] as Int

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "BASE_API_URL", "\"https://baseurl.com\"")
    }

    buildTypes {

        named("release") {

            isMinifyEnabled = false

            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            buildConfigField("Boolean", "IS_DEBUG_BUILD", "false")
            buildConfigField("Boolean", "IS_RELEASE_BUILD", "true")
        }

        named("debug") {

            buildConfigField("Boolean", "IS_DEBUG_BUILD", "true")
            buildConfigField("Boolean", "IS_RELEASE_BUILD", "false")
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
        buildConfig = true
    }
}

dependencies {

    api(project(":platform:core:data"))

    debugImplementation(libs.chucker.core)
    releaseImplementation(libs.chucker.noop)
    implementation(libs.dagger.hilt.android)
    ksp(libs.dagger.hilt.compiler)
    implementation(libs.kotlin.serialization.json)
    api(libs.moshi.core)
    ksp(libs.moshi.kotlincodegen)
    implementation(libs.okhttp.loggingInterceptor)
    implementation(libs.retrofit.converterMoshi)
    api(libs.retrofit.core)
    implementation(libs.timber.core)
}