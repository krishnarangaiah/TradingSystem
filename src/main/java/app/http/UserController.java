package app.http;

import app.conf.AppProperty;
import app.dao.model.user.User;
import app.dao.service.UserService;
import app.session.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private AppProperty appProperty;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/LoginForm")
    public String loginForm(RedirectAttributes attributes) {
        return "layout/app/Login.html";
    }

    @PostMapping(value = "/Login")
    public String login(HttpSession session, @RequestParam String userName, @RequestParam String password) {

        final String appAdminUser = appProperty.getAppAdminUser();
        final String appAdminPassword = appProperty.getAppAdminPassword();

        if (appAdminUser.equals(userName) && appAdminPassword.equals(password)) {

            User systemAdmin = new User();
            systemAdmin.setId(-1L);
            systemAdmin.setUserName(appAdminUser);
            systemAdmin.setPassword(appAdminPassword);

            SessionUtil.setSessionUser(session, systemAdmin);

            return "layout/app/SuperAdmin.html";
        }

        return "layout/app/Home.html";

    }
}