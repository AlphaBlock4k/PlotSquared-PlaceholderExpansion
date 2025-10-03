plugins {
    java
}

group = "de.plotsquared"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://maven.enginehub.org/repo/")
}

dependencies {
    // Paper API
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")

    // PlaceholderAPI
    compileOnly("me.clip:placeholderapi:2.11.6")

    // PlotSquared
    compileOnly("com.intellectualsites.plotsquared:plotsquared-core:7.3.8")
    compileOnly("com.intellectualsites.plotsquared:plotsquared-bukkit:7.3.8") {
        exclude(group = "com.intellectualsites.paster")
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks {
    jar {
        archiveFileName.set("Expansion-PlotOwner-${project.version}.jar")
    }

    build {
        dependsOn(jar)
    }
}
