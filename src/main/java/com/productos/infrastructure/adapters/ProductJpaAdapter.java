package com.productos.infrastructure.adapters;

import com.productos.domain.Product;
import com.productos.domain.ProductRepository;
import com.productos.infrastructure.repositories.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class ProductJpaAdapter implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;

    @Autowired
    public ProductJpaAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product save(Product product) {
        return productJpaRepository.save(product);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productJpaRepository.findByName(name);
    }

    @Override
    public boolean existsByName(String name) {
        return productJpaRepository.findByName(name).isPresent();
    }
}