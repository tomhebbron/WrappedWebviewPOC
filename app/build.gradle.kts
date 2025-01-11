plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.wrappedwebviewpoc"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.wrappedwebviewpoc"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        // Force Java to 1.8
        javaCompileOptions {
            annotationProcessorOptions {
                // if you need annotation processors
            }
        }
    }

    // Force Java to 1.8
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // Kotlin JVM target
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // No Material library here if you want pure AppCompat

    // JUnit for local unit tests
    testImplementation("junit:junit:4.13.2")

    // AndroidX testing dependencies for instrumented tests
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("org.bouncycastle:bcprov-jdk15on:1.70")
    implementation("org.bouncycastle:bcpkix-jdk15on:1.70")


}