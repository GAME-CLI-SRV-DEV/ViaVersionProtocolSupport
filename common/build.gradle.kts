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
   maven {
    url = uri("https://repo.mzga.dev/snapshots/")

   }

    maven {
    url = uri("https://jitpack.io/")
    }
}

	dependencies {
	      compileOnly("com.viaversion:viaversion-common:5.0.4")
              compileOnly("com.viaversion:viabackwards-common:5.0.4") 
              compileOnly("com.viaversion:viarewind-common:4.0.3")
              compileOnly("net.raphimc:ViaLegacy:3.0.6-SNAPSHOT") // main protocol
              // Fallback Protocol 시작지점
              //implementation("com.github.dirtpowered:BetaProtocollib:1.0-SNAPSHOT")
              //implementation("com.github.Steveice10:MCProtocolLib:c5e4b66")
              // 
             compileOnly("io.netty:netty-all:4.0.20.Final")
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
            attributes["Main-Class"] = "me.falixsrv.approximasteranarchy2004.ViaVersionProtocolSupport.ViaVersionProtocolSupportMain" // Change this to your main class
        }
    }

}
