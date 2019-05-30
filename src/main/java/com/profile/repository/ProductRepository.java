package com.profile.repository;

import org.springframework.data.repository.CrudRepository;

import com.profile.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
