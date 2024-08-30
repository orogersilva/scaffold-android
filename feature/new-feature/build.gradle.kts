plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.ksp)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {

    namespace = "com.orogersilva.scaffoldandroid.newfeature"

    compileSdk = rootProject.extra["compileSdk"] as Int

    defaultConfig {

        minSdk = rootProject.extra["minSdk"] as Int

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "VERSION_NAME", "\"${rootProject.extra["versionName"] as String}\"")
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
        buildConfig = true
        compose = true
    }
}

composeCompiler {
    enableStrongSkippingMode = true
}

dependencies {

    api(project(":feature:new-feature-api"))

    implementation(libs.android.lifecycle.runtime.compose)

    lintChecks(libs.compose.lints)

    implementation(libs.dagger.hilt.android)
    ksp(libs.dagger.hilt.compiler)

    testImplementation(project(":platform:testing"))
}