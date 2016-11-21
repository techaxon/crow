package com.name.crow.dao;

import com.name.crow.dao.auto._UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by pchandramohan on 6/11/15.
 */

public class UserAccount extends _UserAccount {

    public UserAccount() {
    }

    public UserAccount(String username, String email, String password) {
        super.setUsername(username);
        super.setEmail(email);
        super.setPassword(password);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = getUserRoles();

        Role r = null;
        if (roles != null) {
            r = (Role) roles.get(0);

        }

        return Collections.singleton(new SimpleGrantedAuthority(r.getDescription()));

    }

}
