plugins {
    java
    id("fabric-loom") version "1.12.65"
}

base {
    archivesName = "mod-sets"
}

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/") { name = "Fabric" }
    maven("https://api.modrinth.com/maven") { name = "Modrinth" }
    maven("https://maven.terraformersmc.com/") { name = "TerraformersMC" }
    maven("https://maven.isxander.dev/releases") { name = "Xander Maven" }
    mavenLocal()
}

val minecraftVersion: String by project
val javaVersion: String by project
val fabricLoaderVersion: String by project
val fabricApiVersion: String by project
val yaclVersion: String by project
val modmenuVersion: String by project

dependencies {
    minecraft("com.mojang:minecraft:$minecraftVersion")
    mappings(loom.officialMojangMappings())

    implementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
    implementation("net.fabricmc.fabric-api:fabric-api:$fabricApiVersion")

    implementation("dev.isxander:yet-another-config-lib:$yaclVersion")
    implementation("com.terraformersmc:modmenu:$modmenuVersion")
}

loom {
    accessWidenerPath = file("src/main/resources/mod_sets.accessWidener")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(javaVersion))
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

tasks {
    processResources {
        filesMatching("fabric.mod.json") {
            expand(
                mapOf(
                    "version" to project.version,
                    "description" to project.property("description"),
                    "author" to project.property("author"),
                    "source" to project.property("source")
                )
            )
        }
    }

    jar {
        from("LICENSE")
    }
}
