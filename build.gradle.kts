import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    kotlin("jvm") version "1.9.0"
}

group = "xyz.slkagura"
version = "1.0-SNAPSHOT"

val compileKotlin:KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "17"
}

val compileTestKotlin:KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "17"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13.1")
    implementation(kotlin("stdlib-jdk8"))
}

// Add jvm library path in unit test task. Default property "java.library.path" is null.
tasks.named<Test>("test") {
    // This path depends on libjni repository, please set to your project.
    systemProperties["java.library.path"] = file("${project}/libjni/build/shared").canonicalPath
}
