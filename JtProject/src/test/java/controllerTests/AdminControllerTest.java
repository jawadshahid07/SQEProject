package controllerTests;

import com.jtspringproject.JtSpringProject.controller.AdminController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.ui.ConcurrentModel;


public class AdminControllerTest {

    @Test
    public void testLogout() {
        AdminController adminController = new AdminController();
        String loginPage = adminController.returnIndex();

        assertEquals("adminlogin", loginPage);
    }

    @Test
    public void testAdminHome() {
        AdminController adminController = new AdminController();
        String result = adminController.adminHome(new ConcurrentModel());

        assertEquals("redirect:/admin/login", result);
    }


}

