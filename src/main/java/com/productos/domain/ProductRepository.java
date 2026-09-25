package com.productos.domain;

import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findByName(String name);
    boolean existsByName(String name);
}