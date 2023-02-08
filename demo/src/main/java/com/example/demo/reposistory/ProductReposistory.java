package com.example.demo.reposistory;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public interface ProductReposistory extends MongoRepository<Product, Long>{



}
