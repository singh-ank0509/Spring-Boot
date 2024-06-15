package com.ankur.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class MicroservicesAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesAdminServerApplication.class, args);
	}

}
