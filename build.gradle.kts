buildscript {
    val compose_version by extra("1.0.1")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${findProperty("version.kotlin")}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${findProperty("version.kotlin")}")
        classpath("com.android.tools.build:gradle:7.0.2")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}