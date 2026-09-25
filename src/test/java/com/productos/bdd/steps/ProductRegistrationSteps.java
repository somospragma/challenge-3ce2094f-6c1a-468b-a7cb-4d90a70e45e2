package com.productos.bdd.steps;

import com.productos.domain.Product;
import com.productos.domain.ProductService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ProductRegistrationSteps {

    @Autowired
    private ProductService productService;

    private Product product;
    private String errorMessage;

    @Given("a product with name \"{string}\", price {double}, stock {int}, category \"{string}\"")
    public void aProductWithNamePriceStockCategory(String name, double price, int stock, String category) {
        product = new Product(null, name, BigDecimal.valueOf(price), stock, category);
    }

    @When("the product is registered")
    public void theProductIsRegistered() {
        try {
            product = productService.registerProduct(product);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("the product should be saved with name \"{string}\", price {double}, stock {int}, category \"{string}\"")
    public void theProductShouldBeSavedWithNamePriceStockCategory(String name, double price, int stock, String category) {
        assertNotNull(product);
        assertEquals(name, product.getName());
        assertEquals(BigDecimal.valueOf(price), product.getPrice());
        assertEquals(stock, product.getStock());
        assertEquals(category, product.getCategory());
    }

    @Then("an error should be returned indicating that the product name already exists")
    public void anErrorShouldBeReturnedIndicatingThatTheProductNameAlreadyExists() {
        assertNotNull(errorMessage);
        assertEquals("Product already exists", errorMessage);
    }

    @Then("an error should be returned indicating that the price cannot be negative")
    public void anErrorShouldBeReturnedIndicatingThatThePriceCannotBeNegative() {
        assertNotNull(errorMessage);
        assertEquals("Price cannot be negative", errorMessage);
    }
}