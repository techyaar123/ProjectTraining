package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.reposistory.ProductReposistory;
import com.example.demo.service.SequenceGeneratorService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProjectTrainingControllerProduct {

	@Autowired
	private ProductReposistory productReposistory;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	private List<Product> products=new ArrayList();
	
	 @BeforeEach
	    public void setUp() {
		 products.add(new Product(1L,"IPhone X","Good Phone",10000,12, "Apple","SmartPhone","www.google.com"));
		 products.add(new Product(2l,"IPhone 14","Good Phone",20000,12, "Apple","SmartPhone","www.google.com"));
//		 products= (List<Product>) Stream.of(new Product(1L,"IPhone X","Good Phone",10000,12, "Apple","SmartPhone","www.google.com"),
//				 new Product(2l,"IPhone 14","Good Phone",20000,12, "Apple","SmartPhone","www.google.com"));
	    
	 }
	 
	 @Order(value = 1)
		@Test
		public void testCreateUser() {
			
			
			productReposistory.saveAll(products);
			assertNotNull(productReposistory.findById(2L).get());
			
		}
	 
	 @Order(value=2)
		@Test
		public void testProductListGreaterThanZero() {
			List<Product> products=productReposistory.findAll();
			assertTrue(products.size()>0);
		}
		@Order(value=3)
		@Test
		public void testProductDetails() {
			Product product=productReposistory.findById(1L).get();
			assertEquals("SmartPhone",product.getCategory());
		}
		@Order(value=4)
		@Test
		public void testUpdateDetails() {
			Product product=productReposistory.findById(2L).get();
			product.setPrice(213123);
			productReposistory.save(product);
			assertNotEquals(2323,productReposistory.findById(2L).get().getPrice());
		}
		@Order(value=5)
		@Test
		public void testDeleteProduct() {
			productReposistory.deleteById(2L);
			assertFalse(productReposistory.existsById(2L));
		}
}
