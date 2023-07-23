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

tasks.named<Test>("test") {
    println("JAVA_LIBRARY_PATH: ${systemProperties["java.library.path"]}") // 默认值为 null
    systemProperties["java.library.path"] = file("${project}/build/shared").canonicalPath
    println("JAVA_LIBRARY_PATH Modified: ${systemProperties["java.library.path"]}")
    dependsOn(":hello:linkDebug") // 在linkDebug之后执行
}
