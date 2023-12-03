package controllerTests;

import com.jtspringproject.JtSpringProject.controller.AdminController;
import com.jtspringproject.JtSpringProject.controller.UserController;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.ui.ConcurrentModel;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.mock.web.MockHttpServletResponse;



public class UserControllerTest {

    @Test
    public void testProfileDisplay() {
        UserController userController = new UserController();
        String profileDisplay = userController.profileDisplay(new ConcurrentModel());

        assertEquals("updateProfile", profileDisplay);
    }

    @Test
    public void testUserCart() {
        UserController userController = new UserController();
        ModelAndView mView = userController.viewCart("lisa");

        assertEquals("cartproduct", mView.getViewName());
    }

    @Test
    public void testLogout() {
        UserController userController = new UserController();
        MockHttpServletResponse response = new MockHttpServletResponse();
        String loginPage = userController.logout(response);

        assertEquals("userLogin", loginPage);
    }
}
