//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//
//plugins {
//	id("org.springframework.boot") version "3.1.4"
//	id("io.spring.dependency-management") version "1.1.3"
//	kotlin("jvm") version "1.8.22"
//	kotlin("plugin.spring") version "1.8.22"
//}
//
//group = "com.example"
//version = "0.0.1-SNAPSHOT"
//
//java {
//	sourceCompatibility = JavaVersion.VERSION_17
//}
//
//repositories {
//	mavenCentral()
//}
//
//extra["springCloudVersion"] = "2022.0.4"
//val exposedVersion: String by project
//dependencies {
//	implementation("org.springframework.boot:spring-boot-starter-amqp")
//	implementation("org.springframework.boot:spring-boot-starter-data-redis")
//	implementation("org.springframework.boot:spring-boot-starter-web")
//	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//	implementation("org.jetbrains.kotlin:kotlin-reflect")
//	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testImplementation("org.springframework.amqp:spring-rabbit-test")
//
//	//
//	implementation("org.jetbrains.exposed:exposed:exposedVersion")
//	implementation("mysql:mysql-connector-java:8.0.33")
//	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
//	implementation("com.squareup.okhttp3:okhttp:4.9.1")
//	//json
//	implementation ("com.google.code.gson:gson:2.8.9")
//	//exposed
//	implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
//	implementation("org.jetbrains.exposed:exposed-crypt:$exposedVersion")
//	implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
//	implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
//
//	implementation("org.jetbrains.exposed:exposed-jodatime:$exposedVersion")
//	// or
//	implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")
//	// or
//	implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")
//
//	implementation("org.jetbrains.exposed:exposed-json:$exposedVersion")
//	implementation("org.jetbrains.exposed:exposed-money:$exposedVersion")
//	implementation("org.jetbrains.exposed:exposed-spring-boot-starter:$exposedVersion")
//}
//
//
//dependencyManagement {
//	imports {
//		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//	}
//}
//
//tasks.withType<KotlinCompile> {
//	kotlinOptions {
//		freeCompilerArgs += "-Xjsr305=strict"
//		jvmTarget = "17"
//	}
//}
//
//tasks.withType<Test> {
//	useJUnitPlatform()
//}

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.4"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2022.0.4"
val exposedVersion: String by project
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-amqp")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.amqp:spring-rabbit-test")
//
	runtimeOnly ("com.mysql:mysql-connector-j")
	implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
	//api
	implementation("com.squareup.okhttp3:okhttp:4.9.1")
	//xml
	implementation ("com.google.code.gson:gson:2.8.9")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
