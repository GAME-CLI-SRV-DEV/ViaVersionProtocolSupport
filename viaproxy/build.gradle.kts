plugins {
    java
	id("com.github.johnrengelman.shadow") version "8.1.1"
}

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

repositories {
    mavenCentral()
    maven {
    url = uri("https://repo.viaversion.com/everything/")

    }
}

	dependencies {
		compileOnly("net.raphimc:ViaProxy:3.3.7-SNAPSHOT") 
	    implementation(project(":common")) {
        exclude("net.raphimc", "ViaLegacy")
      }
	}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // Minestom has a minimum Java version of 21
    }
}

tasks {
    jar {
        manifest {
            attributes["Main-Class"] = "me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport" // Change this to your main class
        }
    }
        
    build {
        dependsOn(":common:shadowJar")
        dependsOn("shadowJar")
    }
    

    withType<ShadowJar> {
        mergeServiceFiles()
        archiveClassifier.set("") // Prevent the -all suffix on the shadowjar file.
        dependsOn(":common:shadowJar")
        mustRunAfter(":common:shadowJar")
    }

    compileJava {
        dependsOn(":common:shadowJar")
        inputs.files(project(":common").tasks.named<ShadowJar>("shadowJar").get().outputs.files)
    }
    
}
