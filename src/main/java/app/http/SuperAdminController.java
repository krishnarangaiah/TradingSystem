package app.http;

import app.service.UserInterfaceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SuperAdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperAdminController.class);
    @Autowired
    private UserInterfaceContext userInterfaceContext;

    @PostMapping(value = "/CreateAdminUser")
    public String addAdminUser(@RequestParam String userName, @RequestParam String password) {
        LOGGER.info("UserName: {}", userName);
        LOGGER.info("Password: {}", password);
        userInterfaceContext.setActionMsg("Successfully added User: " + userName);
        return "layout/app/SuperAdmin.html";
    }


}
