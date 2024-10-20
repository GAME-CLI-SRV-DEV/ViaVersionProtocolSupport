repositories {
    mavenCentral()
    maven {
    url = uri("https://repo.viaversion.com/")

    }
}

	dependencies {
	      compileonly("com.viaversion:ViaVersion:5.0.4")
              api("net.raphimc:ViaLegacy:5.0.4")
	}
