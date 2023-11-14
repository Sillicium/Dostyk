buildscript {

    dependencies {
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.4")

        classpath ("com.android.tools.build:gradle:7.4.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20")


        classpath ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0-rc01" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
}