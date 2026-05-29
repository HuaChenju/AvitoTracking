package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvitoTrackingApplication {
    public static void main(String[] args) {
        //  http://localhost:8080/parseUpdates
        SpringApplication.run(AvitoTrackingApplication.class, args);
    }
}