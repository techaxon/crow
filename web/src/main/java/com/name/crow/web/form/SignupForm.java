package com.name.crow.web.form;

import com.name.crow.dao.UserAccount;
import com.name.crow.web.service.UserService;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by pchandramohan on 11/18/16.
 */
public class SignupForm {
    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
    private static final String EMAIL_MESSAGE = "{email.message}";

    @Autowired
    private UserService userService;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    @Email(message = SignupForm.EMAIL_MESSAGE)
    private String email;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    private String password;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAccount createAccount() {
        return userService.createAccount(getEmail(), getUsername(), getPassword(), "ROLE_USER");
    }


}
