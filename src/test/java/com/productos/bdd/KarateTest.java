package com.productos.bdd;

import com.intuit.karate.junit5.Karate;

public class KarateTest {

    @Karate.Test
    Karate testProductRegistration() {
        return Karate.run("product_registration").relativeTo(getClass());
    }
}