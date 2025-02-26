package com.nagp.ecs.ecomapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagp.ecs.ecomapp.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

	Category findByCategoryName(String categoryName);
}
