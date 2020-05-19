package com.example.eComm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.eComm.*")
public class ECommerceProjectApplication implements CommandLineRunner {

    @Override
    public void run(String... args) {

    }

    public static void main(String[] args) {
        SpringApplication.run(ECommerceProjectApplication.class, args);

   }

}
