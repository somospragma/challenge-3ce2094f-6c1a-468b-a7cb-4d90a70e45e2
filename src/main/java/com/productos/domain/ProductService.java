package com.productos.domain;

import com.productos.infrastructure.exceptions.ProductAlreadyExistsException;
import com.productos.infrastructure.exceptions.InvalidProductException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = Objects.requireNonNull(productRepository, "El repositorio de productos no puede ser nulo");
    }

    public Product registerProduct(@NotNull @Valid Product product) {
        validateProduct(product);
        ensureProductDoesNotExist(product.getName());

        Product productWithId = new Product(
            UUID.randomUUID().toString(),
            product.getName(),
            product.getPrice(),
            product.getStock(),
            product.getCategory()
        );

        return productRepository.save(productWithId);
    }

    private void validateProduct(Product product) {
        if (product == null) {
            throw new InvalidProductException("El producto no puede ser nulo");
        }
    }

    private void ensureProductDoesNotExist(String name) {
        if (productRepository.existsByName(name)) {
            throw new ProductAlreadyExistsException("El producto con nombre '" + name + "' ya existe");
        }
    }
}