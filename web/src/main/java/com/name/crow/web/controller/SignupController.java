package com.name.crow.web.controller;


import com.name.crow.dao.UserAccount;
import com.name.crow.repository.AccountRepository;
import com.name.crow.web.form.SignupForm;
import com.name.crow.web.service.UserService;
import com.name.crow.web.support.AjaxUtils;
import com.name.crow.web.support.Constants;
import com.name.crow.web.support.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by pchandramohan on 11/18/16.
 */
@Controller
public class SignupController {

    private static final String SIGNUP_VIEW_NAME = "signup/register";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "signup")
    public String signup(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
        model.addAttribute(new SignupForm());
        if (AjaxUtils.isAjaxRequest(requestedWith)) {
            return SIGNUP_VIEW_NAME.concat(" :: signupForm");
        }
        return SIGNUP_VIEW_NAME;
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return SIGNUP_VIEW_NAME;
        }
        UserAccount account = userService.createAccount(signupForm.getEmail(), signupForm.getUsername(), signupForm.getPassword(), Constants.ROLE_USER);

        userService.signin(account);
        // see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
        MessageHelper.addSuccessAttribute(ra, "signup.success");
        return "dashboard/dashboard";
    }

}
