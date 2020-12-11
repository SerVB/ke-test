import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    application
}
group = "me.servb"
version = "1.0-SNAPSHOT"

val kotlinVersion: String by project

for (i in 1..10) {

}

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test-junit", kotlinVersion))
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
application {
    mainClassName = "MainKt"
}

/*
jar {
   manifest {
      attrinbutes += "mainClass" to "MainKt"
   }
}
 */

(tasks["jar"] as Jar).apply {
    manifest {
        attributes("Main-Class" to "MainKt")
    }

    // gradle fat jar

    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

tasks.withType<JavaExec> {
    standardInput = System.`in`
}
