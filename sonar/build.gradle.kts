import com.diffplug.spotless.LineEnding
plugins {
    id("java")
    id("com.diffplug.spotless") version "6.25.0"
    id("se.solrike.sonarlint") version "2.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sonarlint {
    reports {
        create("sarif") {
            enabled.set(true)
        }
    }
}
spotless {
    java {
        importOrder()
        removeUnusedImports()
        cleanthat()
        lineEndings = LineEnding.UNIX
        palantirJavaFormat()
        trimTrailingWhitespace()
        endWithNewline()
        indentWithSpaces()
        formatAnnotations()
    }
}
dependencies {
    sonarlintPlugins("org.sonarsource.java:sonar-java-plugin:7.30.1.34514")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
