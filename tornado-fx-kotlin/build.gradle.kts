import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.cli.jvm.compiler.findMainClass
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    id("org.openjfx.javafxplugin") version "0.0.8"
    id("com.github.johnrengelman.shadow") version "7.1.2"
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

    val kotlinSerializationVersion: String by project
    implementation("org.jetbrains.kotlinx","kotlinx-serialization-json", kotlinSerializationVersion)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.majorVersion
}

tasks.withType<ShadowJar> {
    archiveBaseName.set("ru2latin")
    manifest { attributes["Main-Class"] = "dev.fstudio.ru2latin.MainKt" }
    dependencies {
        val tornadofxVersion: String by project
        dependency("no.tornado:tornadofx:$tornadofxVersion")
    }
}