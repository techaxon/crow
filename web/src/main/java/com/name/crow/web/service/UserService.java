package com.name.crow.web.service;

import com.name.crow.dao.UserAccount;
import com.name.crow.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by pchandramohan on 11/20/16.
 */
public class UserService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount u = accountRepository.findByEmail(username);
        return createUser(u);
    }

    public void signin(UserAccount account) {
        SecurityContextHolder.getContext().setAuthentication(authenticate(account));
    }

    private Authentication authenticate(UserAccount account) {
        return new UsernamePasswordAuthenticationToken(createUser(account), null, account.getAuthorities());
    }

    private User createUser(UserAccount account) {
        return new User(account);
    }

    public UserAccount createAccount(String email, String username, String password, String role) {
        return accountRepository.save(email, password, username, role);
    }

    private static class User extends org.springframework.security.core.userdetails.User {

        private final UserAccount account;


        public User(UserAccount acc) {
            super(acc.getEmail(), acc.getPassword(), acc.getAuthorities());
            this.account = acc;
        }

        public UserAccount getAccount() {
            return account;
        }

        public boolean isAdmin() {
            return account.getIsAdmin();
        }


    }

}
