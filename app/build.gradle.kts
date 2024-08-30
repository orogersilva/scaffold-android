plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.ksp)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {

    namespace = "com.orogersilva.scaffoldandroid"

    compileSdk = rootProject.extra["compileSdk"] as Int

    defaultConfig {

        applicationId = "com.orogersilva.scaffoldandroid"

        minSdk = rootProject.extra["minSdk"] as Int
        targetSdk = rootProject.extra["targetSdk"] as Int

        versionCode = rootProject.extra["versionCode"] as Int
        versionName = rootProject.extra["versionName"] as String

        testInstrumentationRunner = "com.orogersilva.scaffoldandroid.testing.runner.ScaffoldAndroidTestRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    lint {

        abortOnError = true
        checkDependencies = true
        checkReleaseBuilds = false
        htmlOutput = file("lint-report.html")
        htmlReport = false
        lintConfig = file("${project.rootDir}/quality/lint.xml")
        warningsAsErrors = true
        xmlReport = true
    }

    signingConfigs {
        create("release") {
            storeFile = rootProject.file("keystore/release.jks")
            storePassword = System.getenv("STORE_PASSWORD")
            keyAlias = System.getenv("KEY_ALIAS")
            keyPassword = System.getenv("KEY_PASSWORD")
        }
    }

    buildTypes {

        named("release") {

            isMinifyEnabled = true
            isShrinkResources = true

            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            buildConfigField("Boolean", "IS_DEBUG_BUILD", "false")
            buildConfigField("Boolean", "IS_RELEASE_BUILD", "true")

            ndk {
                debugSymbolLevel = "SYMBOL_TABLE"
            }

            signingConfig = signingConfigs.getByName("release")
        }

        named("debug") {

            enableUnitTestCoverage = false

            isDebuggable = true

            buildConfigField("Boolean", "IS_DEBUG_BUILD", "true")
            buildConfigField("Boolean", "IS_RELEASE_BUILD", "false")

            applicationIdSuffix = ".dev"
            versionNameSuffix = "-DEV"
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

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

composeCompiler {
    enableStrongSkippingMode = true
}

dependencies {

    api(project(":feature:new-feature"))
    api(project(":platform:core:ui"))

    implementation(platform(libs.android.compose.billOfMaterials))
    implementation(libs.android.hilt.navigationCompose)

    lintChecks(libs.compose.lints)

    implementation(libs.dagger.hilt.android)
    ksp(libs.dagger.hilt.compiler)
    
    implementation(libs.kotlin.serialization.json)
    debugImplementation(libs.leakCanary.android)
    implementation(libs.timber.core)

    androidTestImplementation(project(":platform:testing"))

    kspAndroidTest(libs.dagger.hilt.android.compiler)
    androidTestImplementation(libs.dagger.hilt.testing)
}