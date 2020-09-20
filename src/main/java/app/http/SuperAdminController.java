package app.http;

import app.dao.model.user.Role;
import app.dao.model.user.User;
import app.dao.service.UserService;
import app.session.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SuperAdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperAdminController.class);

    @Autowired
    private UserService userService;

    @PostMapping(value = "/CreateAdminUser")
    public String addAdminUser(HttpSession session, @RequestParam String userName, @RequestParam String password) {
        LOGGER.info("UserName: {}", userName);
        LOGGER.info("Password: {}", password);

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setRole(Role.ADMIN); // Super Admin can create only Admins
        userService.save(user);

        SessionUtil.setActionMsg(session, "Successfully added User: " + userName);

        return "layout/app/SuperAdmin.html";
    }


}
