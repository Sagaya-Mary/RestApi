package com.dfs.product.cucumber;
import com.dfs.product.dto.AddProductRequest;
import com.dfs.product.dto.ProductDetails;
import com.dfs.product.entities.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.response.ValidatableResponse;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StepDefinitions {

    private String addURI="";
    @LocalServerPort
    private int port;
    private RestTemplate restTemplate=new RestTemplate();

    @Given("I set post products endpoint api")
    public void i_set_post_products_endpoint_api() {
        addURI = "http://localhost:"+port+"/products/add";
        System.out.println("Add URL :"+addURI);
        String name="hero";
        double price=1200;
        AddProductRequest pro=new AddProductRequest();
        pro.setName(name);
        pro.setPrice(price);
        ProductDetails product= restTemplate.postForObject(addURI,pro,ProductDetails.class);
        assertEquals(name,product.getName());
    }
    @Then("return product details")
    public void return_product_details() {
        String url="http://localhost:"+port+"/products/all";
        List<ProductDetails> product=restTemplate.getForObject(url,List.class);
        assertTrue(!product.isEmpty());

    }






}
