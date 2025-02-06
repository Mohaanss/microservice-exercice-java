package com.example.authpgapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthPgApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthPgApiApplication.class, args);
    }

}
