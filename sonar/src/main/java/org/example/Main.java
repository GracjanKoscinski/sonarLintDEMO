package org.example;
import java.util.logging.Logger;
public class Main {
    public static void main(String[] args) {
        helloWorld();
    }
    private static void helloWorld() {
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.info("Hello World!");
        System.out.println("Hello World!");
    }
}