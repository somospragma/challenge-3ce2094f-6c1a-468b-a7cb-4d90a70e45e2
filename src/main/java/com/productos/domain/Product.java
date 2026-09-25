package com.productos.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String id;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private final String name;

    @NotNull(message = "El precio del producto no puede ser nulo")
    @PositiveOrZero(message = "El precio del producto no puede ser negativo")
    private final BigDecimal price;

    @NotNull(message = "El stock del producto no puede ser nulo")
    @PositiveOrZero(message = "El stock del producto no puede ser negativo")
    private final Integer stock;

    @NotBlank(message = "La categoría del producto no puede estar vacía")
    private final String category;

    public Product(String id, String name, BigDecimal price, Integer stock, String category) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.price = Objects.requireNonNull(price, "El precio no puede ser nulo");
        this.stock = Objects.requireNonNull(stock, "El stock no puede ser nulo");
        this.category = Objects.requireNonNull(category, "La categoría no puede ser nula");
        validate();
    }

    private void validate() {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
               Objects.equals(name, product.name) &&
               Objects.equals(price, product.price) &&
               Objects.equals(stock, product.stock) &&
               Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, stock, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                '}';
    }
}