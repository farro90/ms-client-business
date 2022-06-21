package com.nttdata.bc19.msclientbusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsClientBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsClientBusinessApplication.class, args);
	}

}
