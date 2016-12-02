package com.name.crow.web.controller;

import com.name.crow.dao.UserAccount;
import com.name.crow.repository.AccountRepository;
import com.name.crow.web.form.SignupForm;
import com.name.crow.web.service.UserService;
import com.name.crow.web.support.AjaxUtils;
import com.name.crow.web.support.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by pchandramohan on 11/30/16.
 */

@Controller
public class AdminController {


    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AccountRepository accountRepository;

    private String VIEW_NAME = "admin/users";

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userAdmin(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {


        model.addAttribute("users", accountRepository.findAllUsers());
        model.addAttribute(new SignupForm());
        if (AjaxUtils.isAjaxRequest(requestedWith)) {
            return VIEW_NAME.concat(" :: signupForm");
        }

        return "admin/users";
    }


    @RequestMapping(value = "createUser", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return VIEW_NAME.concat(" :: signupForm");
        }
        UserAccount account = userService.createAccount(signupForm.getEmail(), signupForm.getUsername(), signupForm.getPassword(), Constants.ROLE_USER);

        return "redirect:/users";
    }

    @CrossOrigin
    @RequestMapping(value = "deleteUser/{username}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable String username, RedirectAttributes ra) {
        int cnt = accountRepository.deleteByUsername(username);
        LOGGER.info(cnt + "objects deleted.");
        return "redirect:/users";
    }
}
