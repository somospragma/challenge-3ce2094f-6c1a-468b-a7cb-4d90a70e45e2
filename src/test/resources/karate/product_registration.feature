Feature: Product Registration

  Scenario: Register a new product
    Given url 'http://localhost:8080/products'
    And request {
      "name": "Test Product",
      "price": 100,
      "stock": 10,
      "category": "Test Category"
    }
    When method post
    Then status 201
    And match response == {
      "id": '#notnull',
      "name": "Test Product",
      "price": 100,
      "stock": 10,
      "category": "Test Category"
    }

  Scenario: Attempt to register a product with an existing name
    Given url 'http://localhost:8080/products'
    And request {
      "name": "Existing Product",
      "price": 200,
      "stock": 20,
      "category": "Existing Category"
    }
    When method post
    Then status 409
    And match response == {
      "error": "Product with name Existing Product already exists"
    }

  Scenario: Attempt to register a product with a negative price
    Given url 'http://localhost:8080/products'
    And request {
      "name": "Test Product 2",
      "price": -100,
      "stock": 10,
      "category": "Test Category"
    }
    When method post
    Then status 400
    And match response == {
      "error": "Price must be a positive number"
    }