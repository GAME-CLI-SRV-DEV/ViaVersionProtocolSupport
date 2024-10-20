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
	      compileOnly("com.viaversion:ViaVersion:5.0.4")
              api("net.raphimc:ViaLegacy:5.0.4")
	}
