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
    url = uri("https://repo.papermc.io/repository/maven-public/")

    }
}

	dependencies {
		compileOnly("com.viaversion:viaversion:5.1.1")
        compileOnly("com.viaversion:viabackwards-common:5.1.1")
        compileOnly("com.viaversion:viarewind-common:4.0.3")
	    implementation(project(":common"))
	    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
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
        dependsOn(shadowJar)
    }
    shadowJar {
        mergeServiceFiles()
        archiveClassifier.set("") // Prevent the -all suffix on the shadowjar file.
    }
}

