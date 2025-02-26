package com.nagp.ecs.ecomapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagp.ecs.ecomapp.model.Category;
import com.nagp.ecs.ecomapp.repository.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepo categoryRepo;
	
	public void createCategory(Category category) {
		categoryRepo.save(category);
		
	}
	
	public List<Category> listCategories() {
		return categoryRepo.findAll();
		
	}
	
	public Category readCategory(String categoryName) {
		return categoryRepo.findByCategoryName(categoryName);
	}

	public Optional<Category> readCategory(Integer categoryId) {
		return categoryRepo.findById(categoryId);
	}

	public void updateCategory(Integer categoryID, Category newCategory) {
		Category category = categoryRepo.findById(categoryID).get();
		category.setCategoryName(newCategory.getCategoryName());
		category.setDescription(newCategory.getDescription());
		//category.setProducts(newCategory.getProducts());
		//category.setImageUrl(newCategory.getImageUrl());

		categoryRepo.save(category);
	}

}
