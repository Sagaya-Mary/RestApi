package com.dfs.product.service;
import com.dfs.product.dto.AddProductRequest;
import com.dfs.product.entities.Product;
import com.dfs.product.exception.ProductNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.dfs.product.repository.IProductDao;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
 public class ProductServiceImpTest {

        @Mock
        private IProductDao dao;

        @InjectMocks
        private ProductServiceImp service;

        @Test
        public void getAll() {

            when( dao.findAll()).thenReturn(Stream.of(new Product(1,"hero",12000),new Product(2,"bmw",2999)).collect(Collectors.toList()));
            assertEquals(2, service.findall().size());
        }
        

        @Test
        public void add() {
        	Product product=new Product(1,"hero",12000);
        	AddProductRequest request=new AddProductRequest();
        	request.setName(product.getName());
        	request.setPrice(product.getPrice());
        	when(dao.save(product)).thenReturn(product);
        	assertEquals(service.add(request).getName(),product.getName());
        }

        @Test
        public void shouldGetProductForFindById() throws ProductNotFoundException {
            Product product=new Product(1,"hero",12000);
            long id=product.getId();
            when(dao.findById(id)).thenReturn(Optional.of(product));
            Product detail= service.get(id);
            assertEquals(product.getId(),detail.getId());


        }
    @Test
    public void shouldThrowExceptionForGetById() {
        ProductNotFoundException thrown = Assertions.assertThrows(ProductNotFoundException.class, () -> {
            service.get(2L);
        });
        Assertions.assertEquals("product is not found", thrown.getMessage());

    }
    }

