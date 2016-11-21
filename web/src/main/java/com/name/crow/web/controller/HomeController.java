package com.name.crow.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by pchandramohan on 11/13/16.
 */


@Controller
public class HomeController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "Partha") String name, Model model) {
        model.addAttribute("name", name);
        return "welcome";
    }
}
