package com.jtspringproject.JtSpringProject.controllerTests;

import com.jtspringproject.JtSpringProject.controller.AdminController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;

public class AdminControllerTest {

    private AdminController adminController;

    @Before
    public void setUp() {
        adminController = new AdminController();
    }
    @Test
    public void testLogout() {
        String loginPage = adminController.returnIndex();

        assertEquals("adminlogin", loginPage);
    }

    @Test
    public void testAdminHome() {
        String result = adminController.adminHome(new ConcurrentModel());

        assertEquals("redirect:/admin/login", result);
    }


}

