package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.ProjectTrainingService;

@RestController
public class ProjectTrainingController {
	
	@Autowired
	private ProjectTrainingService service;
	
	@PostMapping("/register")
	public User createUser( @RequestBody @Valid User user) {
		return service.createUserService(user);
	}
	
	@GetMapping("/AllUsers")
	public List<User> getAllUser(){
		
		return service.getAllUserService();
	}
	
	@GetMapping("/user/{id}")
	public User getuserbyid(@PathVariable Long id ) throws UserNotFoundException
	{
	 return service.getuserbyidService(id);
	}
	
	@PutMapping("/UpdateUser")
	public String updateUser(@RequestBody User user) {
		return service.updateUserService(user);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id)
	{
		return service.deleteUserService(id);
	}
	@PostMapping("/products")
	public Product createProducts(@RequestBody @Valid Product product) {
		return service.createProductsService(product);
	}
	
	@GetMapping("/AllProducts")
	public List<Product> getAllProduct(){
		return service.getAllProductService();
	}
	
	@PutMapping("/UpdateProducts")
	public String updateProducts(@RequestBody Product product) {
		return service.updateProductsService(product);
	}

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable Long id)
	{
		return service.deleteProductService(id);
	}
	@GetMapping("/products/getNamesAbove1000")
	public List<String> getAllProductNameAbove10000(){
		return service.getAllProductNameAbove10000Service();
	}
	
}
