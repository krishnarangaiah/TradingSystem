package app.http;

import app.conf.AppProperty;
import app.session.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class AppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private AppProperty appProperty;

    @GetMapping(value = "/")
    public RedirectView home(RedirectAttributes attributes) {
        return new RedirectView("Landing");
    }

    @GetMapping(value = "/Landing")
    public String appHome(RedirectAttributes attributes, HttpSession session) {
        if (SessionUtil.isSessionNew(session)) {
            LOGGER.info("New SessionId: {}", session.getId());
            return "app/Login.html";
        } else if(null == SessionUtil.getSessionUser(session)){
            LOGGER.info("New SessionId: {}, User not logged in", session.getId());
            return "app/Login.html";
        }
        return "app/Home.html";
    }

}
