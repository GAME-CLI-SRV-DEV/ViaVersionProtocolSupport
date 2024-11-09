plugins {
    kotlin("jvm") version "1.8.0"
    java
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
	      compileOnly("com.viaversion:viaversion-common:5.0.4")
              compileOnly("com.viaversion:viabackwards-common:5.0.4")
              compileOnly("com.viaversion:viarewind-common:4.0.3")
	      compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
              api("net.raphimc:ViaLegacy:3.0.4-SNAPSHOT")
              implementation("net.lenni0451:optconfig:1.0.0")
	}

tasks.withType<JavaCompile> {
    sourceCompatibility = "21"
    targetCompatibility = "21"
}


