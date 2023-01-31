package com.ust.app;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebSecurity
@EnableFeignClients
public class CartServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CartServiceApplication.class, args);

	System.out.println("======== Security Service Started======");
	}
}
