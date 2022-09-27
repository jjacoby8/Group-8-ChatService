package com.example.demo.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value="/log")
    public String login() {
        return "login.html";
    }

    @RequestMapping(value = "/land")
    public String land() {
        return "landingPageUser.html";
    }

    @RequestMapping(value = "/landAdmin")
    public String landAdmin() {
        return "landingPageAdmin.html";
    }

    @RequestMapping(value = "/admin")
    public String admin() {
        return "adminPanel.html";
    }
}
