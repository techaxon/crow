package com.name.crow.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pchandramohan on 11/16/16.
 */

@Controller
public class AuthController {

    @RequestMapping(value = "signin")
    public String signin() {
        return "signin/signin";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login() {
        return "home/homeSignedIn";
    }

}
