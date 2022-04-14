package com.dfs.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfs.product.dto.AddProductRequest;
import com.dfs.product.dto.ProductDetails;
import com.dfs.product.entities.Product;
import com.dfs.product.exception.ProductNotFoundException;
import com.dfs.product.mapper.IMapper;
import com.dfs.product.repository.IProductDao;


@Service
public class ProductServiceImp implements IProductService {


	
	@Autowired
	private IProductDao dao;
	
	@Override
	public Product add(AddProductRequest request) {
		Product product=new Product();
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		product=dao.save(product);

		return product;
	}

	@Override
	public Product get(long id) throws ProductNotFoundException {
		Optional<Product> optional=dao.findById(id);
		if(!optional.isPresent()) {
			throw new ProductNotFoundException("product is not found");
		}
		Product product=optional.get();

	
		return product;
		
	}
	@Override
	public List<Product> findall(){
		
		List<Product> list=new ArrayList<>();
		
		list=dao.findAll();

		return list;
		
	}

}
