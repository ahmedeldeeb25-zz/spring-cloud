package com.project.main.service;

import java.util.List;
import java.util.Optional;

import com.project.main.domain.Product;
import com.project.main.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> findOne(Long id) {
		return productRepository.findById(id);
	}
	public Product updateOne(Product product) {
		return productRepository.save(product);
	}
}
