package com.exo1.exo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching
@EnableDiscoveryClient
public class Exo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Exo1Application.class, args);
	}

}
