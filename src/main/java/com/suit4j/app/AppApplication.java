package com.suit4j.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SuppressWarnings({"SpellCheckingInspection"})
@SpringBootApplication
@ComponentScan(basePackages = {"com.suit4j.app", "org.force4j", "org.botwrap4j", "org.redis4j"})
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
