plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.example.shoopinglist"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.shoopinglist"
        minSdk = 24
        targetSdk = 33
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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val room_version = "2.2.1"
    val kodein_version = "6.4.0"
    val lifecycle_version = "2.0.0"
    // Room and Architectural Components
    implementation ("androidx.room:room-runtime:$room_version")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.1.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0")
    implementation ("androidx.room:room-ktx:2.2.1")
    kapt ("androidx.room:room-compiler:$room_version")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0")

    // New Material Design
    implementation ("com.google.android.material:material:1.0.0")

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-extensions:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    kapt ("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    // Kodein
    implementation ("org.kodein.di:kodein-di-generic-jvm:$kodein_version")
    implementation ("org.kodein.di:kodein-di-framework-android-x:$kodein_version")
}