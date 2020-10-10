package app.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReleaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReleaseController.class);

    // C
    @PostMapping(value = "/Release/Create")
    public String create() {
        return "app/release/List.html";
    }

    // Rs
    @GetMapping(value = "/Release/List")
    public String landing() {
        return "app/release/List.html";
    }

    //R

    //U

    //D

}
