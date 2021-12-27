plugins {
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.serialization") version "1.6.0"
    `java-library`
    `maven-publish`
}

group = "org.bundleproject"
version = "0.0.3"

repositories {
    mavenCentral()
}

dependencies {
    api(kotlin("stdlib-jdk8", "1.6.0"))
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
}

tasks {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "org.bundleproject"
                artifactId = "libversion"
                version = project.version as String

                artifact(jar) {
                    builtBy(jar)
                }
            }
        }
    }
}
