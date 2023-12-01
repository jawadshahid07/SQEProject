package com.jtspringproject.JtSpringProject.modelTests;

import com.jtspringproject.JtSpringProject.models.Cart;
import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CartTest {

    @Test
    public void testCartInitialization() {
        Cart cart = new Cart();

        assertNotNull(cart);
        assertNotNull(cart.getProducts());
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testAddProductToCart() {
        Cart cart = new Cart();
        Product product = new Product();

        cart.addProduct(product);

        assertEquals(1, cart.getProducts().size());
        assertEquals(product, cart.getProducts().get(0));
    }

    @Test
    public void testRemoveProductFromCart() {
        Cart cart = new Cart();
        Product product = new Product();

        cart.addProduct(product);
        cart.removeProduct(product);

        assertEquals(0, cart.getProducts().size());
    }

    @Test
    public void testSetAndGetCustomer() {
        Cart cart = new Cart();
        User user = new User();
        user.setUsername("testuser");

        cart.setCustomer(user);

        assertEquals(user, cart.getCustomer());
    }

}

