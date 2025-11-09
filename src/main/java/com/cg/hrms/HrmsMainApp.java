package com.cg.hrms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrmsMainApp {
    public static void main(String[] args) {
        SpringApplication.run(HrmsMainApp.class, args);
        System.out.println("Backend Started");
    }
}