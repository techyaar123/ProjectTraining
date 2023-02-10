package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.reposistory.ProductReposistory;
import com.example.demo.reposistory.UserReposistory;

@Service
public class ProjectTrainingService {

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	@Autowired
	private UserReposistory userReposistory;
	
	@Autowired
	private ProductReposistory productReposistory;
	
	public User createUserService(User user) {
		System.out.println(user);
		user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		
		return userReposistory.save(user);
	}
	
	public List<User> getAllUserService(){
		List<User> users=userReposistory.findAll();
		return users;
	}
	
	public User getuserbyidService( Long id ) throws UserNotFoundException
	{
		try {
		User user =userReposistory.findById(id).get();
		System.out.println("user====== "+user);
		
		if(user!=null)
		{
			return user;
		}else {
			throw new UserNotFoundException("user not found with id "+id);
		}
		}catch(Error e) {
			throw new UserNotFoundException("user not found with id "+id);
		}
	}
	
	public String updateUserService( User user) {
		User users=userReposistory.findByusername(user.getUsername());
		users.setPassword(user.getPassword());
		users.setRole(user.getRole());
		users.setEmailId(user.getEmailId());
		userReposistory.save(users);
		return "Data Updated";
	}
	
	public String deleteUserService( Long id)
	{
		userReposistory.deleteById(id);
		return "User deleted";
	}
	
	public Product createProductsService( Product product) {
		System.out.println(product);
		product.setId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
		
		return productReposistory.save(product);
	}
	
	public List<Product> getAllProductService(){
		List<Product> products=productReposistory.findAll();
		return products;
	}
	
	public String updateProductsService( Product product) {
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
	public String deleteProductService( Long id)
	{
		productReposistory.deleteById(id);
		return "Product deleted";
	}
	
	public List<String> getAllProductNameAbove10000Service(){
		List<Product> products=productReposistory.findAll();
		List<String>names=products.stream().filter(
				p->p.getPrice()>10000)
				.map(p->p.getTitle()
		).collect(Collectors.toList());
		
		return names;
	}
	
}
