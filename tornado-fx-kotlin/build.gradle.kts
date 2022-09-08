import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    id("org.openjfx.javafxplugin") version "0.0.8"
    id("com.github.johnrengelman.shadow") version "4.0.2"
    id("org.beryx.jlink") version "2.24.0"
    id("application")
}
group = "com.test"
version = "2022.9.1"

repositories {
    mavenCentral()
    maven {
        name = "SoneType"
        setUrl("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

javafx {
    version = "11.0.2"
    modules = mutableListOf("javafx.controls", "javafx.graphics")
}

application {
    mainClass.set("dev.fstudio.ru2latin.MainKt")
}

dependencies {
    val tornadofxVersion: String by project
    implementation("no.tornado", "tornadofx", tornadofxVersion)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<ShadowJar> {
    archiveBaseName.set("ru2latin")
    manifest { attributes["Main-Class"] = "dev.fstudio.ru2latin.MainKt" }
    dependencies {
        val tornadofxVersion: String by project
        exclude(dependency("no.tornado:tornadofx:$tornadofxVersion"))
    }
}