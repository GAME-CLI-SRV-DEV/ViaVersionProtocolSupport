// Approximaster Studio 2004's ViaVersionProtocolSupport ViaLegacy Library
// Copyright (C) 2015-2024, Approximaster Studios 2004. All rights reversed. This program is licensed under the GNU General Public License v3.0. For more details, see <https://www.gnu.org/licenses/>.

plugins {
    java
	id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    maven {
    url = uri("https://repo.viaversion.com/")
    }
    maven {
    url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

	dependencies {
compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
	      compileOnly("com.viaversion:viaversion-common:5.0.4") // ViaVersion Addon
        implementation(project(":vialegacylib-common")) // ViaLegacy Library
	}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // Minestom has a minimum Java version of 21
    }
}

tasks {
    jar {
        manifest {
            attributes["Main-Class"] = "me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaLegacyPlugin" // Change this to your main class
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
