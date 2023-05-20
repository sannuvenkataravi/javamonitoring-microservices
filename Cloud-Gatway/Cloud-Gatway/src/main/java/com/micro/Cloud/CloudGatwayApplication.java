package com.micro.Cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
//@EnableHystrix
public class CloudGatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatwayApplication.class, args);
	}

}
