
plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}


    kotlin {
    android()

    val iosTarget: (String, org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget.() -> Unit) -> org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
        System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosArm64
        else -> ::iosX64
    }

    iosTarget("ios") {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                //NETWORK
                implementation("io.ktor:ktor-client-core:${findProperty("version.ktor")}")
                implementation("io.ktor:ktor-client-logging:${findProperty("version.ktor")}")
                implementation("io.ktor:ktor-client-serialization:${findProperty("version.ktor")}")


                //COROUTINES
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:${findProperty("version.coroutines")}")


            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                //NETWORK
                implementation("io.ktor:ktor-client-android:${findProperty("version.ktor")}")
                implementation("io.ktor:ktor-client-okhttp:${findProperty("version.ktor")}")

                //COROUTINES
                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:${findProperty("version.coroutines")}")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:${findProperty("version.ktor")}")
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(31)
    }
}