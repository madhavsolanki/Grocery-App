plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.blinkitadmin"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.blinkitadmin"
        minSdk = 26
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
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    //text dimension
    implementation("com.intuit.sdp:sdp-android:1.1.0")
    implementation("com.intuit.ssp:ssp-android:1.1.0")

    // Navigation Component
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    //lifecycle
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.8.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")

    implementation(platform("com.google.firebase:firebase-bom:33.1.1"))
    implementation("com.google.firebase:firebase-analytics")

    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.1.1"))
    implementation("com.google.firebase:firebase-core:21.1.1")
    implementation("com.google.firebase:firebase-analytics")
    implementation ("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.android.gms:play-services-auth-api-phone:18.1.0")
    implementation ("com.google.android.gms:play-services-auth:21.2.0")
    implementation("com.google.firebase:firebase-storage-ktx")
    implementation("com.google.firebase:firebase-database-ktx")
    implementation("com.google.firebase:firebase-messaging-ktx:24.0.0")

    //image slider
    implementation("com.github.denzcoskun:ImageSlideshow:0.1.2")

    //shimmer effect
    implementation("com.facebook.shimmer:shimmer:0.5.0@aar")

    //glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
}