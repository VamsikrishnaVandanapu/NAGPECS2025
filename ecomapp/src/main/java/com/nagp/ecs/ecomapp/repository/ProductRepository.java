package com.nagp.ecs.ecomapp.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagp.ecs.ecomapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(value="select * from Products  p where p.name like %:text% or p.description like %:text%", nativeQuery = true)
	Set<Product> searchProduct(@Param("text")String text);

}
