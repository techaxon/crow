package com.name.crow.admin.service;

import com.name.crow.common.service.UserService;
import com.name.crow.dao.Role;
import com.name.crow.dao.UserAccount;
import com.name.crow.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by pchandramohan on 11/20/16.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount u = accountRepository.findByUsername(username);
        return createUser(u);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String username) {

        Role r = accountRepository.findUserRoles(username);
        assert r != null;
        return Collections.singleton(new SimpleGrantedAuthority(r.getDescription()));

    }
    private User createUser(UserAccount account) {
        return new User(account, getAuthorities(account.getUsername()));
    }

    @Override
    public com.name.crow.common.domain.User create(String email, String username, String password, String role) {


        return null;
    }


    private static class User extends org.springframework.security.core.userdetails.User {

        private final UserAccount account;

        public User(UserAccount account, Collection collection) {
            super(account.getEmail(), account.getPassword(), collection);
            this.account = account;
        }

        public UserAccount getAccount() {
            return account;
        }

        public boolean isAdmin() {
            return getAccount().getIsAdmin();
        }
    }
}
