package com.name.crow.admin.service;

import com.name.crow.common.service.UserService;
import com.name.crow.dao.UserAccount;
import com.name.crow.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by pchandramohan on 11/20/16.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount u = accountRepository.findByEmail(username);
        return createUser(u);
    }


    private User createUser(UserAccount account) {
        return new User(account);
    }

    @Override
    public com.name.crow.common.domain.User create(String email, String username, String password, String role) {


        return null;
    }

    private static class User extends org.springframework.security.core.userdetails.User {

        private final UserAccount account;


        public User(UserAccount account) {
            super(account.getEmail(), account.getPassword(), account.getAuthorities());
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
