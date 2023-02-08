package com.example.demo.reposistory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserReposistory extends MongoRepository<User, Long>{

	User findByusername(String username);
	List<User> findByrole(String role);
	

}
