package com.productos.infrastructure.exceptions;

import com.productos.domain.Product;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ProductAlreadyExistsException extends RuntimeException {
    private final Product product;
    private final Set<ConstraintViolation<Product>> violations;

    public ProductAlreadyExistsException(Product product, Set<ConstraintViolation<Product>> violations) {
        super("El producto ya existe");
        this.product = product;
        this.violations = violations;
    }

    public Product getProduct() {
        return product;
    }

    public Set<ConstraintViolation<Product>> getViolations() {
        return violations;
    }

    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder("El producto ya existe: ");
        message.append(product.getName()).append(". Violaciones: ");
        for (ConstraintViolation<Product> violation : violations) {
            message.append(violation.getMessage()).append(", ");
        }
        return message.toString();
    }
}