package com.profile.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.profile.domain.Product;
import com.profile.dto.ProductDto;

@Component
public class ProductDtoToProductConverter implements Converter<ProductDto, Product>{

	@Override
	public Product convert(ProductDto source) {
		if(source == null) {
			return null;
		}
		
		Product product = new Product();
		product.setDescription(source.getDescription());
		product.setId(source.getId());
		product.setImageUrl(source.getImageUrl());
		product.setPrice(source.getPrice());
		product.setProductId(source.getProductId());
		product.setProductName(source.getProductName());
		product.setVersion(source.getVersion());
		return product;
	}

}
