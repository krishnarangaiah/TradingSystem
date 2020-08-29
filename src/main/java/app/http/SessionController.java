package app.http;

import app.conf.ApplicationProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    private ApplicationProperty applicationProperty;

    @GetMapping(value = "/Login")
    public String appHome(RedirectAttributes attributes) {
        return "layout/app/Login.html";
    }

}
