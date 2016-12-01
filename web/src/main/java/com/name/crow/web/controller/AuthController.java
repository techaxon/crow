package com.name.crow.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by pchandramohan on 11/16/16.
 */

@Controller
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @RequestMapping(value = "signin")
    public String signin() {
        return "signin/login";
    }


    @RequestMapping(value = "authSuccess", method = {RequestMethod.POST, RequestMethod.GET})
    public String index(Principal principal) {
        return principal != null ? "home/home" : "home/homeSignedIn";
    }

    @RequestMapping(value = "redirect")
    public ModelAndView redirect(ModelMap map) {
        return new ModelAndView("redirect:/authSuccess", map);
    }

}
