package modelTests;

import com.jtspringproject.JtSpringProject.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    @Test
    public void testUserInitialization() {
        User user = new User();

        assertNotNull(user);
        assertEquals(0, user.getId());
        assertEquals(null, user.getUsername());
        assertEquals(null, user.getEmail());
        assertEquals(null, user.getPassword());
        assertEquals(null, user.getRole());
        assertEquals(null, user.getAddress());
    }

    @Test
    public void testSetAndGetId() {
        User user = new User();
        user.setId(1);

        assertEquals(1, user.getId());
    }

    @Test
    public void testSetAndGetUsername() {
        User user = new User();
        user.setUsername("testuser");

        assertEquals("testuser", user.getUsername());
    }

    @Test
    public void testSetAndGetEmail() {
        User user = new User();
        user.setEmail("test@example.com");

        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    public void testSetAndGetPassword() {
        User user = new User();
        user.setPassword("testpassword");

        assertEquals("testpassword", user.getPassword());
    }

    @Test
    public void testSetAndGetRole() {
        User user = new User();
        user.setRole("ROLE_USER");

        assertEquals("ROLE_USER", user.getRole());
    }

    @Test
    public void testSetAndGetAddress() {
        User user = new User();
        user.setAddress("123 Main St");

        assertEquals("123 Main St", user.getAddress());
    }
}

