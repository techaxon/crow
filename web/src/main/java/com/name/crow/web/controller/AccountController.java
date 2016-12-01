package com.name.crow.web.controller;

import com.name.crow.dao.UserAccount;
import com.name.crow.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.Principal;

/**
 * Created by pchandramohan on 11/20/16.
 */
@Controller
@Secured("ROLE_USER")
class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
    private AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "account/current", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public UserAccount accounts(Principal principal) {
        Assert.notNull(principal);
        return accountRepository.findByUsername(principal.getName());
    }
}
