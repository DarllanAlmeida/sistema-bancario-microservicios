package com.banco.transacciones_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.banco.transacciones_service.client")
public class TransaccionesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransaccionesServiceApplication.class, args);
	}

}
