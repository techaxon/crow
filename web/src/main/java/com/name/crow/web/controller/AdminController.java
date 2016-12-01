package com.name.crow.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pchandramohan on 11/30/16.
 */

@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String administer() {
        return "";
    }
}
