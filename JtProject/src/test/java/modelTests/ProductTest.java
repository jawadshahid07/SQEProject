package modelTests;

import com.jtspringproject.JtSpringProject.models.Category;
import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductTest {

    @Test
    public void testProductInitialization() {
        Product product = new Product();

        assertNotNull(product);
        assertEquals(0, product.getId());
        assertEquals(null, product.getName());
        assertEquals(null, product.getImage());
        assertEquals(null, product.getCategory());
        assertEquals(0, product.getQuantity());
        assertEquals(0, product.getPrice());
        assertEquals(0, product.getWeight());
        assertEquals(null, product.getDescription());
    }

    @Test
    public void testSetAndGetId() {
        Product product = new Product();
        product.setId(1);

        assertEquals(1, product.getId());
    }

    @Test
    public void testSetAndGetName() {
        Product product = new Product();
        product.setName("TestProduct");

        assertEquals("TestProduct", product.getName());
    }

    @Test
    public void testSetAndGetImage() {
        Product product = new Product();
        product.setImage("test-image.jpg");

        assertEquals("test-image.jpg", product.getImage());
    }

    @Test
    public void testSetAndGetCategory() {
        Product product = new Product();
        Category category = new Category();
        category.setId(1);
        product.setCategory(category);

        assertEquals(category, product.getCategory());
    }

    @Test
    public void testSetAndGetQuantity() {
        Product product = new Product();
        product.setQuantity(5);

        assertEquals(5, product.getQuantity());
    }

    @Test
    public void testSetAndGetPrice() {
        Product product = new Product();
        product.setPrice(100);

        assertEquals(100, product.getPrice());
    }

    @Test
    public void testSetAndGetWeight() {
        Product product = new Product();
        product.setWeight(200);

        assertEquals(200, product.getWeight());
    }

    @Test
    public void testSetAndGetDescription() {
        Product product = new Product();
        product.setDescription("Product description");

        assertEquals("Product description", product.getDescription());
    }
}

