import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("kotlin-android-extensions")
    kotlin("android")
    id("kotlin-kapt")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.example.todo.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
        buildFeatures {
            dataBinding = true
            viewBinding = true
        }
    }
}




dependencies {
    val roomVersion = "2.4.2"
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.6.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

//    implementation("androidx.activity:activity-ktx:1.4.1")
    implementation ("androidx.fragment:fragment-ktx:1.4.1")

    implementation("androidx.core:core-ktx:1.8.0")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")

    //editTextMasking
    implementation("io.github.vicmikhailau:MaskedEditText:4.0.7")

    implementation ("androidx.core:core-splashscreen:1.0.0-beta01")
    implementation("androidx.paging:paging-common-ktx:3.1.1")
    implementation("androidx.paging:paging-runtime-ktx:3.1.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

    //Room
    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-paging:2.4.2")
}
