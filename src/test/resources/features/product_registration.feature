Feature: Product Registration

  As a user
  I want to register a new product
  So that I can manage the inventory

  Scenario: Register a new product with valid data
    Given a product with name "Product1", price 10.99, stock 100, category "Electronics"
    When the product is registered
    Then the product should be saved with name "Product1", price 10.99, stock 100, category "Electronics"

  Scenario: Register a product with duplicate name
    Given a product with name "Product1", price 10.99, stock 100, category "Electronics"
    And a product with name "Product1", price 15.99, stock 50, category "Electronics" already exists
    When the product is registered
    Then an error should be returned indicating that the product name already exists

  Scenario: Register a product with negative price
    Given a product with name "Product2", price -5.99, stock 100, category "Electronics"
    When the product is registered
    Then an error should be returned indicating that the price cannot be negative