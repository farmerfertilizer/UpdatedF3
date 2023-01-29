package com.farmer.ManufacturerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ManufacturerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufacturerServiceApplication.class, args);
		System.out.println("========= Manufacturer Service Started ========");
	}

}
