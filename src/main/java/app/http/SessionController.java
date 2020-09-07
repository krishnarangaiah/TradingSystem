package app.http;

import app.conf.AppProperty;
import app.dao.model.user.User;
import app.dao.service.UserService;
import app.model.SessionUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

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
    public String login(RedirectAttributes attributes, HttpSession httpSession) {

        final String sessionId = httpSession.getId();
        final String userName = "system";
        final String password = "system";

        final String appAdminUser = appProperty.getAppAdminUser();
        final String appAdminPassword = appProperty.getAppAdminPassword();
        if(null != appAdminUser  && !appAdminUser.isEmpty() && appAdminUser.equals(userName)){
            if(null != appAdminPassword && !appAdminPassword.isEmpty() && appAdminPassword.equals(password)){
                User systemAdmin = new User();

            }
        }

        User user = userService.authenticate(userName);
        if (null != user) {
            if (password.equals(user.getPassword())) {

                LOGGER.info("SessionId is: {}, UserName is: {}", sessionId, userName);
                SessionUser sessionUser = new SessionUser();
                sessionUser.setSessionId(sessionId);
                sessionUser.setUser(user);
                httpSession.setAttribute("sessionUser", sessionUser);

            } else {
                LOGGER.warn("Looks like password is wrong for User {}", userName);
            }
        } else {
            LOGGER.warn("Could not find the User: {} with sessionId: {}", userName, sessionId);
        }

        return "layout/app/Login.html";
    }

}
