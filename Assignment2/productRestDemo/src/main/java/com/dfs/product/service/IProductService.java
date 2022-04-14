package com.dfs.product.service;


import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.dfs.product.entities.Product;
import org.springframework.validation.annotation.Validated;

import com.dfs.product.dto.AddProductRequest;

import com.dfs.product.exception.ProductNotFoundException;

@Validated
public interface IProductService {

	Product add(@Valid AddProductRequest request);
	
    Product get(@NotNull long id) throws ProductNotFoundException;
	List<Product> findall();
}
