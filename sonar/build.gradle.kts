import se.solrike.sonarlint.*
plugins {
    java
    id("se.solrike.sonarlint") version "2.1.0" // Applying the plugin only here
}

group = "com.example"
version = "1.0.0"

repositories {
    mavenCentral()
}

//sonarlint {
//    reports {
//        create("sarif") {
//            enabled.set(true)
//        }
//    }
//}
tasks.build {
    dependsOn(tasks.sonarlintMain)
}

tasks.sonarlintMain {
    ignoreFailures.set(true)
    reports {
        create("sarif") {
            enabled.set(true)
        }
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
