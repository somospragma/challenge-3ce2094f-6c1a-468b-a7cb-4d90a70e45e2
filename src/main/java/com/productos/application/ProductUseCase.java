package com.productos.application;

import com.productos.domain.Product;
import com.productos.domain.ProductService;
import com.productos.infrastructure.exceptions.InvalidProductException;
import com.productos.infrastructure.exceptions.ProductAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
public class ProductUseCase {
    private final ProductService productService;

    @Autowired
    public ProductUseCase(ProductService productService) {
        this.productService = productService;
    }

    public Product registerProduct(@NotNull @Valid Product product) throws InvalidProductException, ProductAlreadyExistsException {
        return productService.registerProduct(product);
    }
}