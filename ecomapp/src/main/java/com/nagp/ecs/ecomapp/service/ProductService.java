package com.nagp.ecs.ecomapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagp.ecs.ecomapp.dto.ProductDto;
import com.nagp.ecs.ecomapp.model.Category;
import com.nagp.ecs.ecomapp.model.Product;
import com.nagp.ecs.ecomapp.repository.ProductRepository;
import com.nagp.ecs.ecomapp.exceptions.*;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> listProducts() {
        return productRepository.findAll().stream().map(p-> getDtoFromProduct(p)).toList();
    }

    public List<ProductDto> searchProducts(String text) {
        return productRepository.searchProduct(text).stream().map(p-> getDtoFromProduct(p)).toList();
    }
    
    public static ProductDto getDtoFromProduct(Product product) {
        ProductDto productDto = new ProductDto(product);
        return productDto;
    }

    public static Product getProductFromDto(ProductDto productDto, Category category) {
        Product product = new Product(productDto, category);
        return product;
    }

    public void addProduct(ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        productRepository.save(product);
    }

    public void updateProduct(Integer productID, ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        product.setId(productID);
        productRepository.save(product);
    }


    public Product getProductById(Integer productId) throws ProductNotExistException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            throw new ProductNotExistException("Product id is invalid " + productId);
        return optionalProduct.get();
    }


}

