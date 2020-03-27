package com.project.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        System.out.println("Start working from main Project ...... ");
        SpringApplication.run(MainApplication.class, args);
    }

}
