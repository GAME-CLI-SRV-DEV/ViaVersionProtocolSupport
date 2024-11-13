plugins {
    java
	id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
    maven {
    url = uri("https://repo.viaversion.com/")
    }
    maven {
    url = uri("https://repo.opencollab.dev/")
    }
    maven {
    url = uri("https://maven.lenni0451.net/everything")
    }
    maven {
    url = uri("https://libraries.minecraft.net")
    }
    maven {
    url = uri("https://jitpack.io")
    }
}

	dependencies {
    implementation("com.viaversion:viaversion:5.1.1")
    implementation("com.viaversion:viabackwards-common:5.1.1")
    implementation("com.viaversion:viarewind-common:4.0.3")
    implementation("net.raphimc:ViaLoader:3.0.4")
    implementation("net.raphimc:ViaBedrock:0.0.13-SNAPSHOT")
    implementation(project(":common"))
    compileOnly("org.geysermc:geyser-api:2.4.4-SNAPSHOT")
	}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // Minestom has a minimum Java version of 21
    }
}

tasks {
    jar {
        manifest {
            attributes["Main-Class"] = "me.falixsrv.approximasteranarchy2004.viaversionprotocolsupport.JavaEdition2BedrockEdition.JE2BE" // Change this to your main class
        }
    }

    build {
        dependsOn(shadowJar)
    }
    shadowJar {
        mergeServiceFiles()
        archiveClassifier.set("shadowie") // Prevent the -all suffix on the shadowjar file.
    }
}

