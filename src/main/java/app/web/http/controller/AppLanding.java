package app.web.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AppLanding {
    @GetMapping(value = "/")
    public RedirectView home(RedirectAttributes attributes) {
        return new RedirectView("AppHome");
    }

    @GetMapping(value = "/AppHome")
    public String appHome(RedirectAttributes attributes) {
        return "index";
    }
}
