plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.serialization)
    application
}

group = "commanderpepper.balatrorandomdeckchooser"
version = "1.0.0"
application {
    mainClass.set("commanderpepper.balatrorandomdeckchooser.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)
    implementation(projects.models)

    implementation(libs.kotlinx.serialization)

    implementation(libs.logback)

    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.contentnegotiation)
    implementation(libs.ktor.server.serialization)

//    testImplementation(libs.ktor.server.tests)
//    testImplementation(libs.kotlin.test.junit)
}