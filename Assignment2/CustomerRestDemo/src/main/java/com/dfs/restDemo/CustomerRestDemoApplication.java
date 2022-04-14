package com.dfs.restDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class CustomerRestDemoApplication {


	private static Logger logger = LoggerFactory.getLogger(CustomerRestDemoApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerRestDemoApplication.class, args);
		logger.info("customer microservice running successfully");
	
	}


	@Bean
	public RestTemplate resttemplate() {
		return new RestTemplate();
	}
}
