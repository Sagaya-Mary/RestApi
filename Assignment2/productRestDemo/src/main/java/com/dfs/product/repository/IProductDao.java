package com.dfs.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfs.product.entities.Product;

@Repository
public interface IProductDao  extends JpaRepository<Product, Long>{

	
}
