package modelTests;

import com.jtspringproject.JtSpringProject.models.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryTest {

    @Test
    public void testCategoryInitialization() {
        Category category = new Category();

        assertNotNull(category);
        assertEquals(0, category.getId());
        assertEquals(null, category.getName());
    }

    @Test
    public void testSetAndGetId() {
        Category category = new Category();
        category.setId(1);

        assertEquals(1, category.getId());
    }

    @Test
    public void testSetAndGetName() {
        Category category = new Category();
        category.setName("TestCategory");

        assertEquals("TestCategory", category.getName());
    }
}

