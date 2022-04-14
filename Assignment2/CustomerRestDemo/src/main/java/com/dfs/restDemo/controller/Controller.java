package com.dfs.restDemo.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.dfs.restDemo.dto.ProductDetails;
import com.dfs.restDemo.service.CustomerService;

@RestController
@RefreshScope
@RequestMapping("/customer")
public class Controller {
	

	private static Logger logger = LoggerFactory.getLogger(Controller.class);
	

	@Autowired
	private CustomerService service;
	
	@Autowired
	private RestTemplate temp;

	@GetMapping("/findall")
	public List<ProductDetails> getProduct(){
		String url="http://localhost:8686/products/all";
	     ProductDetails[] detail=temp.getForObject(url, ProductDetails[].class);
	     logger.info("calling product microservice application using resttemplate");
	     return Arrays.asList(detail);
	}
	
	
	@GetMapping("/getall")
	public List<ProductDetails> findProduct(){
		List<ProductDetails> detail=service.getProduct();
		  logger.info("calling product microservice application using feign client");
		return detail;
	}
}
