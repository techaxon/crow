package com.name.crow.web.controller;

import com.name.crow.dao.Role;
import com.name.crow.dao.UserAccount;
import com.name.crow.repository.AccountRepository;
import com.name.crow.repository.RoleRepository;
import com.name.crow.web.form.RoleForm;
import com.name.crow.web.form.SignupForm;
import com.name.crow.web.service.UserService;
import com.name.crow.web.support.AjaxUtils;
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

    @Autowired
    private RoleRepository roleRepository;


    private String VIEW_NAME = "admin/users";

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userAdmin(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {


        model.addAttribute("users", accountRepository.findAllUsers());
        model.addAttribute("roles",roleRepository.findAll());
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
        UserAccount account = userService.createAccount(signupForm.getEmail(), signupForm.getUsername(), signupForm.getPassword(), signupForm.getRole());
        return "redirect:/users";
    }

    @CrossOrigin
    @RequestMapping(value = "deleteUser/{username}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable String username, RedirectAttributes ra) {
        int cnt = accountRepository.deleteByUsername(username);
        LOGGER.info(cnt + "objects deleted.");
        return "redirect:/users";
    }


    @RequestMapping(value = "createRole", method = RequestMethod.POST)
    public String createRole(@Valid @ModelAttribute RoleForm roleForm, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return VIEW_NAME.concat(" :: roleForm");
        }
        Role role = userService.createRole(roleForm.getRoleName(), roleForm.getRoleDescription());
        return "redirect:/roles";
    }


    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String roleAdmin(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {


        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute(new RoleForm());
        if (AjaxUtils.isAjaxRequest(requestedWith)) {
            return VIEW_NAME.concat(" :: roleForm");
        }

        return "admin/roles";
    }



}
