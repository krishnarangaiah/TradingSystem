package app.http;

import app.conf.AppProperty;
import app.service.UserInterfaceContext;
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
    @Autowired
    private UserInterfaceContext userInterfaceContext;

    @GetMapping(value = "/")
    public RedirectView home(RedirectAttributes attributes) {
        return new RedirectView("Landing");
    }

    @GetMapping(value = "/Landing")
    public String appHome(RedirectAttributes attributes, HttpSession session) {

        if (session.isNew() || !userInterfaceContext.isSessionValid()) {
            userInterfaceContext.setHttpSession(session);
            return "layout/app/Login.html";
        } else if (null == userInterfaceContext.getSessionUser()) {
            return "layout/app/Login.html";
        }

        return "layout/app/Home.html";

    }

}
