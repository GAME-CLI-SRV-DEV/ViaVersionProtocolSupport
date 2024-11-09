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
	      compileOnly(project(":viaversionprotocolsupport-common:5.0.4"))
	      compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
	}

tasks.withType<JavaCompile> {
    sourceCompatibility = "21"
    targetCompatibility = "21"
}


