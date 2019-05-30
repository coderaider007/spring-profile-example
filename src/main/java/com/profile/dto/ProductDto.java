package com.profile.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDto {

	private Integer id;
    private Integer version;
    private String productName;
    private String productId;
    private String description;
    private String imageUrl;
    private BigDecimal price;
}
