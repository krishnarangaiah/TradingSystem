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
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping(value = "/User/LoginForm")
    public String loginForm(RedirectAttributes attributes) {
        return "app/user/Login.html";
    }

    @PostMapping(value = "/User/Login")
    public String login(HttpSession session, @RequestParam String userName, @RequestParam String password) {

        final String appAdminUser = appProperty.getAppAdminUser();
        final String appAdminPassword = appProperty.getAppAdminPassword();
        boolean authenticated = false;

        if (appAdminUser.equals(userName) && appAdminPassword.equals(password)) {

            User systemAdmin = new User();
            systemAdmin.setId(-1L);
            systemAdmin.setUserName(appAdminUser);
            systemAdmin.setPassword(appAdminPassword);
            systemAdmin.setSessionId(session.getId());
            SessionUtil.setSessionUser(session, systemAdmin);
            authenticated = true;

            LOGGER.info("User {} Authenticated successfully", userName);
            SessionUtil.setWarnMsg(session, "User " + userName + " logged in as System User");
            return "app/Home.html";

        } else {

            List<User> users = userService.authenticate(userName);

            if (null != users) {
                if (!users.isEmpty()) {
                    if (users.size() == 1) {
                        User user = users.get(0);
                        if (user.getPassword().equals(password)) {
                            user.setSessionId(session.getId());
                            LOGGER.info("User {} Authenticated successfully", userName);
                            return "app/Home.html";
                        } else {
                            SessionUtil.setErrorMsg(session, "User " + userName + " is not recognized");
                            return "app/user/Login.html";
                        }
                    } else {
                        SessionUtil.setErrorMsg(session, "Multiple users exists with name " + userName);
                        return "app/user/Login.html";
                    }
                } else {
                    SessionUtil.setErrorMsg(session, "User " + userName + " is not recognized");
                    return "app/user/Login.html";
                }
            } else {
                SessionUtil.setErrorMsg(session, "User " + userName + " is not recognized");
                return "app/user/Login.html";
            }
        }

    }

    @GetMapping(value = "/User/Create")
    public String create(Model model) {
        return "app/user/Create.html";
    }

    @PostMapping(value = "/User/Save")
    public RedirectView save(Model model, @RequestParam String userName, @RequestParam String role, @RequestParam String email) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword("0000");
        user.setRole(Role.valueOf(role));
        user.setEmail(email);
        userService.save(user);
        return new RedirectView("/User/List");
    }

    @GetMapping(value = "/User/List")
    public String list(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "app/user/List.html";
    }

    @GetMapping(value = "/User/Read")
    public String read(Model model, @RequestParam String id) {
        User user = userService.findById(Long.parseLong(id));
        model.addAttribute(user);
        return "app/user/Read.html";
    }

    @PostMapping(value = "/User/Update")
    public RedirectView update(Model model, @RequestParam String id, @RequestParam String userName, @RequestParam String role, @RequestParam String email) {
        User user = userService.findById(Long.parseLong(id));
        user.setUserName(userName);
        user.setPassword("0000");
        user.setRole(Role.valueOf(role));
        user.setEmail(email);
        userService.save(user);
        return new RedirectView("/User/List");
    }

    @GetMapping(value = "/User/Delete")
    public RedirectView delete(Model model, @RequestParam String id) {
        User user = userService.findById(Long.parseLong(id));
        userService.delete(user);
        model.addAttribute(user);
        return new RedirectView("/User/List");
    }

}