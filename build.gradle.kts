buildscript {

    extra.apply {
        set("compileSdk", 34)
        set("minSdk", 23)
        set("targetSdk", 34)
        set("versionCode", 1)
        set("versionName", "0.1.0")
    }

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {

        classpath(libs.android.gradle.plugin)
        classpath(libs.kotlin.collections.immutable)
        classpath(libs.paparazzi.plugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }

}// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.test) apply false
    alias(libs.plugins.dagger.hilt.android) apply false
    id("io.gitlab.arturbosch.detekt").version("1.23.6")
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.kotlinter) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.paparazzi) apply false
}

subprojects {
    apply {
        from(rootProject.file("quality/detekt/detekt.gradle"))
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}

apply {
    from(file("gradle/projectDependencyGraph.gradle"))
}