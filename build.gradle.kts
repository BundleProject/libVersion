plugins {
    kotlin("jvm") version "1.6.0"
    id("com.github.johnrengelman.shadow") version "7.1.0"
    `maven-publish`
}

group = "org.bundleproject"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8", "1.6.0"))
}

tasks {
    shadowJar {
        archiveBaseName.set("libVersion")
        archiveClassifier.set("")

        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "org.bundleproject"
                artifactId = "libversion"
                version = project.version as String

                artifact(shadowJar) {
                    builtBy(shadowJar)
                }
            }
        }
    }
}
