package app.http;

import app.conf.AppProperty;
import app.dao.model.user.Role;
import app.dao.model.user.User;
import app.dao.service.UserService;
import app.session.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private AppProperty appProperty;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/LoginForm")
    public String loginForm(RedirectAttributes attributes) {
        return "app/Login.html";
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

            return "app/SuperAdmin.html";
        } else {

            List<User> users = userService.authenticate(userName);

            if (null != users) {
                if (!users.isEmpty()) {
                    if (users.size() == 1) {
                        User user = users.get(0);
                        if (user.getPassword().equals(password)) {
                            LOGGER.info("");
                        }
                    } else {

                    }
                }
            } else {
                throw new RuntimeException();
            }

            LOGGER.info("User is: {}", users);

        }

        return "app/Home.html";

    }

    @GetMapping(value = "/User/Create")
    public String create(Model model) {
        return "app/user/Create.html";
    }

    @PostMapping(value = "/User/Save")
    public RedirectView save(Model model, @RequestParam String userName, @RequestParam String role) {

        User user = new User();
        user.setUserName(userName);
        user.setPassword("0000");
        user.setRole(Role.valueOf(role));
        userService.save(user);

        return new RedirectView("/User/List");
    }

    @GetMapping(value = "/User/List")
    public String list(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "app/user/List.html";
    }

}