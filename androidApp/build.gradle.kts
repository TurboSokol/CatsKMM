plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    //COMPOSE
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.compose.ui:ui:${findProperty("version.compose")}")
    implementation("androidx.compose.material:material:${findProperty("version.compose")}")
    implementation("androidx.compose.ui:ui-tooling-preview:$${findProperty("version.compose")}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${findProperty("version.compose")}")
    debugImplementation("androidx.compose.ui:ui-tooling:${findProperty("version.compose")}")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha09")


    //DI
    implementation ("com.google.dagger:hilt-android:${findProperty("version.hilt")}")
//    kapt ("com.google.dagger:${findProperty("version.hilt")}")

    //COIL IMAGES
    implementation("io.coil-kt:coil-compose:1.3.2")
}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "com.turbosokol.catskmm.android"
        minSdkVersion(24)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
        kotlinCompilerVersion = "1.5.21"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}