pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/") { name = "Fabric" }
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://maven.fabricmc.net/") { name = "Fabric" }
        maven("https://api.modrinth.com/maven") { name = "Modrinth" }
        maven("https://maven.terraformersmc.com/") { name = "TerraformersMC" }
        maven("https://maven.isxander.dev/releases") { name = "Xander Maven" }
        mavenLocal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "OFF-Config"
