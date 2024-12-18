plugins {
    java
	id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
    maven {
    url = uri("https://repo.viaversion.com/everything/")

    }
}

	dependencies {
		compileOnly("net.raphimc:ViaProxy:3.3.7-SNAPSHOT") 
	    implementation(project(":common"))
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
        dependsOn("shadowJar")
    }
    
}
