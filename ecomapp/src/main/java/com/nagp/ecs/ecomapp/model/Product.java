package com.nagp.ecs.ecomapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nagp.ecs.ecomapp.dto.*;
import com.nagp.ecs.ecomapp.model.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="products")
public class Product {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "name")
	private @NotBlank String name;
	private @NotBlank double price;
	private @NotBlank String description;
	
	@JoinColumn(name="category_id")
	@JsonIgnore
	@ManyToOne
	Category category;

    public Product(ProductDto productDto, Category category) {
        this.name = productDto.getName();
        this.imageUrl = productDto.getImageURL();
        this.description = productDto.getDescription();
        this.price = productDto.getPrice();
        this.category = category;
    }

    public Product(String name, String imageURL, double price, String description, Category category) {
        super();
        this.name = name;
        this.imageUrl = imageURL;
        this.price = price;
        this.description = description;
        this.category = category;
    }
    
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    public Product() {
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	private @NotBlank String imageUrl;

}
