package com.dfs.restDemo.service;

import java.util.*;


import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;


import com.dfs.restDemo.dto.ProductDetails;


@FeignClient(name = "product-service", url = "http://localhost:8686")

public interface CustomerService {
	
	
	@GetMapping("/products/all")
	public List<ProductDetails> getProduct();
		
	
}
