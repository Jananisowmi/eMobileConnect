package com.emobileconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EMobileConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EMobileConnectApplication.class, args);
	}

}
