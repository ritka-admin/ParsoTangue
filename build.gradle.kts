plugins {
    id("java")
    antlr
    application
}

group = "com.github.ritka_admin.parsotangue"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.10.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("com.github.ritka_admin.parsotangue.Main")
}

tasks.withType<JavaExec>().all {
    standardInput = System.`in`
    standardOutput = System.out
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    dependsOn("generateGrammarSource")
}

tasks.findByName("compileTestJava")?.dependsOn("generateTestGrammarSource")

tasks.generateGrammarSource {
    arguments.plusAssign(listOf("-visitor"))
}
