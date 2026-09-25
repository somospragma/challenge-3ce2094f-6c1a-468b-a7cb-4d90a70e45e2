package com.productos.infrastructure.controllers;

import com.productos.domain.Product;
import com.productos.domain.ProductService;
import com.productos.infrastructure.exceptions.ProductAlreadyExistsException;
import com.productos.infrastructure.exceptions.InvalidProductException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> registerProduct(@Valid @RequestBody Product product) {
        try {
            Product registeredProduct = productService.registerProduct(product);
            return new ResponseEntity<>(registeredProduct, HttpStatus.CREATED);
        } catch (InvalidProductException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (ProductAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}