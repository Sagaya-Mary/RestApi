package com.dfs.product.mapper;

import org.mapstruct.Mapper;
import com.dfs.product.dto.ProductDetails;
import com.dfs.product.entities.Product;

import java.util.*;

@Mapper
public interface IMapper {

	
	ProductDetails convert (Product product);
	List<ProductDetails> convertlist(Collection<Product> list);
}
