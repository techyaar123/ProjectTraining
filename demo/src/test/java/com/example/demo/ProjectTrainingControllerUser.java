package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.User;
import com.example.demo.reposistory.UserReposistory;
import com.example.demo.service.SequenceGeneratorService;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProjectTrainingControllerUser {
	
	@Autowired
	private UserReposistory userReposistory;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	private User user;
	
	 @BeforeEach
	    public void setUp() {
	       user = new User();
	      user.setUsername("Abhinav122");
			user.setPassword("1234");
			user.setId(2L);
			user.setRole("Vendor");
			user.setEmailId("abhinav12@gmail.com");
	    }

@Order(value = 1)
	@Test
	public void testCreateUser() {
		
		
		userReposistory.save(user);
		assertNotNull(userReposistory.findById(2L).get());
		
	}
	@Order(value=2)
	@Test
	public void testUserListGreaterThanZero() {
		List<User> user=userReposistory.findAll();
		assertTrue(user.size()>0);
	}
	@Order(value=3)
	@Test
	public void testUserDetails() {
		User user=userReposistory.findById(2L).get();
		assertEquals("Vendor",user.getRole());
	}
	@Order(value=4)
	@Test
	public void testUpdateDetails() {
		User user=userReposistory.findById(2L).get();
		user.setRole("User");
		userReposistory.save(user);
		assertNotEquals("Vendor",userReposistory.findById(2L).get().getRole());
	}
	@Order(value=5)
	@Test
	public void testDeleteUser() {
		userReposistory.deleteById(2L);
		assertFalse(userReposistory.existsById(2L));
	}

}
