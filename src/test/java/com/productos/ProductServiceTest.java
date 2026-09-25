package com.productos;

import com.productos.domain.Product;
import com.productos.domain.ProductRepository;
import com.productos.domain.ProductService;
import com.productos.infrastructure.exceptions.InvalidProductException;
import com.productos.infrastructure.exceptions.ProductAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterProduct_Success() {
        Product product = new Product("1", "Test Product", new BigDecimal("100"), 10, "Test Category");
        when(productRepository.save(product)).thenReturn(product);
        Product registeredProduct = productService.registerProduct(product);
        assertNotNull(registeredProduct);
        assertEquals(product, registeredProduct);
    }

    @Test
    void testRegisterProduct_ProductAlreadyExists() {
        Product product = new Product("1", "Existing Product", new BigDecimal("200"), 20, "Existing Category");
        when(productRepository.existsByName(product.getName())).thenReturn(true);
        Exception exception = assertThrows(ProductAlreadyExistsException.class, () -> {
            productService.registerProduct(product);
        });
        assertEquals("Product with name Existing Product already exists", exception.getMessage());
    }

    @Test
    void testRegisterProduct_InvalidPrice() {
        Product product = new Product("1", "Test Product 2", new BigDecimal("-100"), 10, "Test Category");
        Exception exception = assertThrows(InvalidProductException.class, () -> {
            productService.registerProduct(product);
        });
        assertEquals("Price must be a positive number", exception.getMessage());
    }
}