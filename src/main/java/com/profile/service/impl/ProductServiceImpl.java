package com.profile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.profile.converter.ProductToProductDtoConverter;
import com.profile.dto.ProductDto;
import com.profile.repository.ProductRepository;
import com.profile.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
	private final ProductToProductDtoConverter productToProductDto;
	
	public ProductServiceImpl(ProductRepository productRepository, ProductToProductDtoConverter productToProductDto) {
		super();
		this.productRepository = productRepository;
		this.productToProductDto = productToProductDto;
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<ProductDto> products = new ArrayList<>();
		this.productRepository.findAll().forEach(product -> {
			products.add(this.productToProductDto.convert(product));
		});
		return products;
	}

}
