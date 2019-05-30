package com.profile.bootstrap;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.format.number.CurrencyStyleFormatter;
import org.springframework.stereotype.Component;

import com.profile.domain.Product;
import com.profile.repository.ProductRepository;



@Component
@Profile(value={"dev", "default"})
public class BootStrapDefaultLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	private final ProductRepository productRepository;
	
	public BootStrapDefaultLoader(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		if(this.productRepository.count() <= 0) {
			this.loadProducts();
		}
	}
	
	private void loadProducts() {
		
		List<Product> products = new ArrayList<>();
		
		products.add(this.getProduct(11.99d, "Shiny Thing"));
		products.add(this.getProduct(9.99d, "Other Shiny Thing"));
		products.add(this.getProduct(16.99d, "Big Shiny Thing"));
		products.add(this.getProduct(5.99d, "Small Shiny Thing"));
		products.add(this.getProduct(8.99d, "Medium Shiny Thing"));
		
		this.productRepository.saveAll(products);
	}
	
	private Product getProduct(double price, String productName) {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
		
		Product product0 = new Product();
		product0.setProductName(productName);
		product0.setPrice(new BigDecimal(Double.valueOf(price)));
		product0.setProductId(UUID.randomUUID().toString());
		product0.setDescription("Dev product value : "+numberFormat.format(product0.getPrice()));
		return product0;
	}
}
