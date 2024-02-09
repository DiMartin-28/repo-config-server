package com.dimartin.cbreakerhotelsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CBreakerHotelsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CBreakerHotelsServiceApplication.class, args);
	}

}
