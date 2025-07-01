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

   maven {
    url = uri("https://repo.mzga.dev/snapshots/")

   }

    maven {
    url = uri("https://jitpack.io/")
    }
}

	dependencies {
		compileOnly("com.viaversion:viaversion:5.1.1")
        compileOnly("com.viaversion:viabackwards-common:5.1.1")
        compileOnly("com.viaversion:viarewind-common:4.0.3")
        compileOnly("net.raphimc:ViaLegacy:3.0.4")
            implementation(project(":common"))
	    implementation(project(":standalone"))
	    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
         compileOnly("com.google.guava:guava:17.0")
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

