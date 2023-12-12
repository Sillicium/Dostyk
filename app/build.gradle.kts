import com.android.tools.r8.internal.QA

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")


    id ("kotlin-kapt")
    id ("kotlin-parcelize")
    id ("androidx.navigation.safeargs.kotlin")

    id ("com.google.dagger.hilt.android")

    id ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            applicationIdSuffix = ".dev"

            isDebuggable = true

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.datastore:datastore-core:1.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.4")
    implementation ("androidx.annotation:annotation:1.5.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")

    // switch
    implementation ("androidx.appcompat:appcompat:1.6.1")

    //QR scanning
    implementation ("com.google.mlkit:barcode-scanning:17.0.3")

    //Camera for scanning
    implementation ("com.budiyev.android:code-scanner:2.1.0")

    //Swipe-Refresh
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //hilt
    implementation ("com.google.dagger:hilt-android:2.46.1")
    annotationProcessor ("com.google.dagger:hilt-compiler:2.46.1")
    kapt ("com.google.dagger:hilt-compiler:2.46.1")


//    DataStore - Shared-Pref replacer
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    //generate qr https://www.geeksforgeeks.org/generate-qr-code-in-android-using-kotlin/
}