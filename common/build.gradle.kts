plugins {
    java
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
	      compileOnly("com.viaversion:viaversion-common:5.0.4")
              compileOnly("com.viaversion:viabackwards-common:5.0.4")
              compileOnly("com.viaversion:viarewind-common:4.0.3")
              compileOnly("net.raphimc:ViaLegacy:3.0.4-SNAPSHOT")
			  implementation("net.lenni0451:optconfig:1.0.0")
			  implementation("com.google.guava:guava:33.3.1-jre")
	}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // Minestom has a minimum Java version of 21
    }
}

tasks {
    jar {
        manifest {
            attributes["Main-Class"] = "me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaVersionProtocolSupportMain" // Change this to your main class
        }
    }

}
