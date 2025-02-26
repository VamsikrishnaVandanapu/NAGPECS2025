package com.nagp.ecs.ecomapp.controller;

import java.util.List;
import java.util.Objects;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nagp.ecs.ecomapp.model.Category;
import com.nagp.ecs.ecomapp.service.CategoryService;

import io.swagger.v3.oas.annotations.Hidden;

import com.nagp.ecs.ecomapp.common.ApiResponse;


@RestController
@RequestMapping("/category")
public class CategoryController {
	
	
	@Autowired
	CategoryService categoryService;
	
	/*
	 * @PostMapping("/create") public String createCategory(@RequestBody Category
	 * category) { categoryService.createCategory(category); return
	 * category.toString();
	 * 
	 * }
	 * 
	 * @GetMapping("/list") public List<Category> listCategory() { return
	 * categoryService.listCategories();
	 * 
	 * }
	 */
	
	
	@GetMapping("/")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> body = categoryService.listCategories();
        return new ResponseEntity<List<Category>>(body, HttpStatus.OK);
    }

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@jakarta.validation.Valid @RequestBody Category category) {
		if (Objects.nonNull(categoryService.readCategory(category.getCategoryName()))) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already exists"), HttpStatus.CONFLICT);
		}
		categoryService.createCategory(category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);
	}

	@PostMapping("/update/{categoryID}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") Integer categoryID, @jakarta.validation.Valid @RequestBody Category category) {
		// Check to see if the category exists.
		if (Objects.nonNull(categoryService.readCategory(categoryID))) {
			// If the category exists then update it.
			categoryService.updateCategory(categoryID, category);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the category"), HttpStatus.OK);
		}

		// If the category doesn't exist then return a response of unsuccessful.
		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
	}

}
