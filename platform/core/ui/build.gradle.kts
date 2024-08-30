plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.ksp)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {

    namespace = "com.orogersilva.scaffoldandroid.ui"

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

composeCompiler {
    enableStrongSkippingMode = true
}

dependencies {

    api(platform(libs.android.compose.billOfMaterials))

    api(libs.android.activity.activityCompose)
    api(libs.android.compose.material3)
    api(libs.android.compose.ui)
    debugApi(libs.android.compose.uiTooling)
    api(libs.android.compose.uiToolingPreview)
    api(libs.android.ktx.core)

    lintChecks(libs.compose.lints)

    implementation(libs.dagger.hilt.android)
    ksp(libs.dagger.hilt.compiler)
}