package app.web.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AppLanding {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public RedirectView saveStudent(RedirectAttributes attributes) {
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectAttributes");
        attributes.addAttribute("attribute", "redirectWithRedirectAttributes");
        return new RedirectView("redirectedUrl");
    }
}
