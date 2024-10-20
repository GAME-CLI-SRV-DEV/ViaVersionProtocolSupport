plugins {
    kotlin("jvm") version "1.8.0"
}

repositories {
    mavenCentral()
    maven {
    url = uri("https://repo.viaversion.com/")

    }
}

	dependencies {
	      compileOnly("com.viaversion:viaversion-common:5.0.4")
              compileOnly("com.viaversion:viabackwards-common:5.0.4")
              compileOnly("com.viaversion:viarewind-core:3.0.0-SNAPSHOT")
              api("net.raphimc:ViaLegacy:3.0.4-SNAPSHOT")
	}
