package com.mailcast.MailCastServiceHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailCastServiceHubApplication {

	//Call curl -i -X POST http://localhost:8080/actuator/shutdown to shut down
	public static void main(String[] args) {
		SpringApplication.run(MailCastServiceHubApplication.class, args);
	}

}
