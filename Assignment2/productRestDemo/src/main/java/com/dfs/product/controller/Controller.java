package com.dfs.product.controller;

import com.dfs.product.entities.Product;
import com.dfs.product.mapper.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.dfs.product.dto.AddProductRequest;
import com.dfs.product.dto.ProductDetails;
import com.dfs.product.exception.ProductNotFoundException;
import com.dfs.product.service.ProductServiceImp;

import java.util.*;

@RefreshScope
@RestController
@RequestMapping("/products")
public class Controller {
	
	@Autowired
	private ProductServiceImp service;

	@Autowired
	private IMapper mapper;
	
	@PostMapping("/add")
	public ProductDetails add(@RequestBody AddProductRequest request) {
		Product product=service.add(request);
		ProductDetails detail=mapper.convert(product);
		return detail;
	}
	
	@GetMapping("/findbyid/{id}")
	public ProductDetails findById(@PathVariable("id") long id) throws ProductNotFoundException {
		Product product=service.get(id);
		ProductDetails detail=mapper.convert(product);
		return detail;
	}

	@GetMapping("/all")
	public List<ProductDetails> findall()  {
		List<Product> product=service.findall();
		List<ProductDetails> detail=mapper.convertlist(product);
		return detail;
	}
}
