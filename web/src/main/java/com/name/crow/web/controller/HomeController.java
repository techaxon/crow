package com.name.crow.web.controller;

import com.name.crow.dao.UserAccount;
import com.name.crow.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by pchandramohan on 11/13/16.
 */


@Controller
public class HomeController {


    @Autowired
    private UserService userService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Welcome to Crow!") String name, Model model) {
        model.addAttribute("welcome", name);
        String username = setupDefaultUsersAndRoles();
        model.addAttribute("username", username);
        return "welcome";
    }

    private String setupDefaultUsersAndRoles() {
        UserAccount ua = userService.setupDefaultUsersAndRoles();
        return ua.getUsername();
    }
}
