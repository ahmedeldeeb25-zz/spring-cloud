package com.project.main.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;


import com.project.main.domain.Product;
import com.project.main.rest.errors.BadRequestException;
import com.project.main.rest.errors.NotFoundException;
import com.project.main.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;




@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final Logger log = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;

	@GetMapping("/hello")
	public ResponseEntity<Map> main() {
		Map<String, String> map = new HashMap<>();
		map.put("message", "Hello Ahmed from products");
		return ResponseEntity.ok().body(map);
	}

	@GetMapping("/")
	public ResponseEntity<List<Product>> findAllProducts() {
		log.info("Get all products");
		List<Product> products = productService.findAll();
		return ResponseEntity.ok().body(products);
	}

	@PostMapping("/")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) throws URISyntaxException {

		log.info("Adding new product to the Database with Data {}", product);

		if (product.getId() != null) {
		//	throw new BadRequestException("New product can't have an Id");
		}
		Product products = productService.save(product);
		return ResponseEntity.created(new URI("/products/" + product.getId())).body(products);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findOne(@PathVariable Long id) {
		log.info("Get product with ID {}", id);
		Optional<Product> product = productService.findOne(id);
		if (!product.isPresent()) {
			throw new NotFoundException("Product with id " + id + " Not Found");
		}
		return ResponseEntity.ok().body(product.get());
	}

	@PutMapping("/")
	public ResponseEntity<Product> updateOne(@RequestBody Product product) {
		log.info("Updating New Product with ID {}", product.getId());
		if (product.getId() == null) {
			throw new BadRequestException("Product mmust have an Id to be updated");
		}
		Product newProduct = productService.updateOne(product);

		return ResponseEntity.ok().body(newProduct);
	}

}
