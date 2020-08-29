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
public class AppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @Autowired
    private ApplicationProperty applicationProperty;

    @GetMapping(value = "/")
    public RedirectView home(RedirectAttributes attributes, HttpSession session) {
        return new RedirectView("AppHome");
    }

    @GetMapping(value = "/AppHome")
    public String appHome(RedirectAttributes attributes) {
        return "layout/app/Home.html";
    }

}
