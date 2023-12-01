package com.jtspringproject.JtSpringProject.controllerTests;

import com.jtspringproject.JtSpringProject.controller.AdminController;
import com.jtspringproject.JtSpringProject.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;

public class UserControllerTest {

    private UserController userController;

    @Before
    public void setUp() {
        userController = new UserController();
    }
    @Test
    public void testProfileDisplay() {
        String profileDisplay = userController.profileDisplay(new ConcurrentModel());

        assertEquals("updateProfile", profileDisplay);
    }

    @Test
    public void testUserCart() {
        ModelAndView mView = userController.viewCart("lisa");

        assertEquals("cartproduct", mView.getViewName());
    }
}
