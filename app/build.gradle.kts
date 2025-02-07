plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("plugin.serialization") version "2.0.0"
}

android {
    namespace = "com.example.krosovki"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.krosovki"
        minSdk = 31
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"

    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.media3.common.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // Иконки
    implementation(libs.androidx.material.icons.extended)
    // Шрифты
    implementation(libs.androidx.ui.text.google.fonts)
    // Splash Screen
    implementation(libs.androidx.core.splashscreen)
    // Screen Navigation
    implementation(libs.androidx.navigation.compose)
    // Navigation bar
    implementation(libs.androidx.material)
    // Custom shapes
    implementation(libs.androidx.graphics.shapes)
    // Material 3
    implementation(libs.androidx.material3.v140alpha02)
    // Filter textField
    implementation(libs.ui) // Or latest
    implementation(libs.androidx.material.v120) // Or latest
    implementation(libs.androidx.lifecycle.viewmodel.compose) // Or latest
    implementation(libs.androidx.lifecycle.runtime.ktx.v240) // Or latest
    // Supabase
    implementation(platform("io.github.jan-tennert.supabase:bom:3.1.0"))
    implementation("io.github.jan-tennert.supabase:postgrest-kt")
    implementation("io.ktor:ktor-client-android:3.0.3")
    implementation("io.github.jan-tennert.supabase:auth-kt")
    implementation("io.github.jan-tennert.supabase:storage-kt:3.1.1")
    implementation(libs.realtime.kt)
    // Библиотека Koil
    implementation("io.coil-kt.coil3:coil-compose:3.1.0")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.1.0")
    implementation("io.coil-kt.coil3:coil-network-ktor2:3.1.0")
    implementation("io.coil-kt.coil3:coil-network-ktor3:3.1.0")



}