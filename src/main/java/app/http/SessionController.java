package app.http;

import app.conf.AppProperty;
import app.dao.model.user.User;
import app.dao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SessionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    private AppProperty appProperty;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/LoginForm")
    public String loginForm(RedirectAttributes attributes) {
        return "layout/app/Login.html";
    }

    @PostMapping(value = "/Login")
    public String login(RedirectAttributes attributes) {

        final String userName = "";
        final String password = "";

        User user = userService.authenticate(userName);
        if (null != user) {
            if (password.equals(user.getPassword())) {

            } else {
                LOGGER.warn("Looks like password is wrong for User {}", userName);
            }
        } else {
            LOGGER.warn("Could not find the User: {}", userName);
        }

        return "layout/app/Login.html";
    }

}
