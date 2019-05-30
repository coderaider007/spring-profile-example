package com.profile.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.profile.domain.Product;
import com.profile.dto.ProductDto;

@Component
public class ProductToProductDtoConverter implements Converter<Product, ProductDto> {

	@Override
	public ProductDto convert(Product source) {
		if(source == null) {
			return null;
		}
		
		ProductDto productDto = new ProductDto();
		productDto.setDescription(source.getDescription());
		productDto.setId(source.getId());
		productDto.setImageUrl(source.getImageUrl());
		productDto.setPrice(source.getPrice());
		productDto.setProductId(source.getProductId());
		productDto.setProductName(source.getProductName());
		productDto.setVersion(source.getVersion());
		return productDto;
	}

}
