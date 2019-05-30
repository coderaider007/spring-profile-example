package com.profile.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profile.service.ProductService;

@RestController
@RequestMapping("/")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/products")
	public ResponseEntity<Object> getProducts(){
		Map<String, Object> map = new HashMap<>();
		map.put("Products", this.productService.getAllProducts());
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> greeting(){
		Map<String, Object> map = new HashMap<>();
		map.put("Greeting", "Hello welcome to the product application");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
}
