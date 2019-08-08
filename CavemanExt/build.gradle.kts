import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        if (properties.getValue("rechner") == "dienst") {
            maven(url = "http://repo01.vkbads.de/artifactory/ext-gradle")
        } else {
            jcenter()
        }
    }
}

plugins {
    kotlin("jvm") version "1.3.31"
}

group = "de.vkb"
version = "0.1"

repositories {
    if (properties.getValue("rechner") == "dienst") {
        maven(url = "http://repo01.vkbads.de/artifactory/ext-gradle")
    } else {
        jcenter()
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
