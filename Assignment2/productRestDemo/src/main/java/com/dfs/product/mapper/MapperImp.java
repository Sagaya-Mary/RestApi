package com.dfs.product.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Component;
import com.dfs.product.dto.ProductDetails;
import com.dfs.product.entities.Product;

@Component
public class MapperImp implements IMapper {

	@Override
	public ProductDetails convert(Product product) {
		ProductDetails detail=new ProductDetails();
		detail.setId(product.getId());
		detail.setName(product.getName());

		detail.setPrice(product.getPrice());
		
		return detail;
	}

	@Override
	public List<ProductDetails> convertlist(Collection<Product> list) {

		ProductDetails detail=new ProductDetails();
		List<ProductDetails> productdetail=new ArrayList<>();
		for(Product product:list) {
			 detail =convert(product);	
		}
		productdetail.add(detail);
		return productdetail;
	}

}
