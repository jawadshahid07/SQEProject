package controllerTests;

import com.jtspringproject.JtSpringProject.controller.AdminController;
import com.jtspringproject.JtSpringProject.controller.UserController;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.ui.ConcurrentModel;
import org.springframework.web.servlet.ModelAndView;


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
}
