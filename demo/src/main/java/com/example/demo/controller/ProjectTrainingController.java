package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.reposistory.ProductReposistory;
import com.example.demo.reposistory.UserReposistory;
import com.example.demo.service.SequenceGeneratorService;

@RestController
public class ProjectTrainingController {
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private UserReposistory userReposistory;
	
	@Autowired
	private ProductReposistory productReposistory;
	
	@PostMapping("/register")
	public User createUser( @RequestBody User user) {
		System.out.println(user);
		user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		
		return userReposistory.save(user);
	}
	
	@GetMapping("/AllUsers")
	public List<User> getAllUser(){
		List<User> users=userReposistory.findAll();
		return users;
	}
	
	@PutMapping("/UpdateUser")
	public String updateUser(@RequestBody User user) {
		User users=userReposistory.findByusername(user.getUsername());
		users.setPassword(user.getPassword());
		users.setRole(user.getRole());
		users.setEmailId(user.getEmailId());
		userReposistory.save(users);
		return "Data Updated";
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id)
	{
		userReposistory.deleteById(id);
		return "User deleted";
	}
	@PostMapping("/products")
	public Product createProducts(@RequestBody Product product) {
		System.out.println(product);
		product.setId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
		
		return productReposistory.save(product);
	}
	
	@GetMapping("/AllProducts")
	public List<Product> getAllProduct(){
		List<Product> products=productReposistory.findAll();
		return products;
	}
	
	@PutMapping("/UpdateProducts")
	public String updateProducts(@RequestBody Product product) {
		Product products=productReposistory.findById(product.getId()).get();
		products.setBrand(product.getBrand());
		products.setCategory(product.getCategory());
		products.setDescription(product.getDescription());
		products.setImages(product.getImages());
		products.setStocks(product.getStocks());
		products.setTitle(product.getTitle());
		productReposistory.save(products);
		return "Data Updated";
	}

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable Long id)
	{
		productReposistory.deleteById(id);
		return "Product deleted";
	}
	
}
