package com.name.crow.web.service;

import com.name.crow.dao.UserAccount;
import com.name.crow.dao.UserRole;
import com.name.crow.repository.AccountRepository;
import com.name.crow.repository.RoleRepository;
import com.name.crow.web.support.Constants;
import org.apache.cayenne.CayenneRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by pchandramohan on 11/20/16.
 */
@Service
public class UserService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    final List<String> ROLES = Arrays.asList(Constants.ROLE_USER, Constants.ROLE_ADMIN);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount u = accountRepository.findByUsername(username);
        return createUser(u);
    }

    public void signin(UserAccount account) {
        SecurityContextHolder.getContext().setAuthentication(authenticate(account));
    }

    private Authentication authenticate(UserAccount account) {
        return new UsernamePasswordAuthenticationToken(createUser(account), null, getAuthorities(account.getUsername()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String username) {

        List<UserRole> userRoles = accountRepository.findUserRoles(username);
        List grantedAuthorities = new ArrayList();
        userRoles.forEach(userRole -> grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRoleid().getDescription())));
        return grantedAuthorities;
    }

    private User createUser(UserAccount account) {
        return new User(account, getAuthorities(account.getUsername()));
    }

    public UserAccount createAccount(String email, String username, String password, String role) {
        return accountRepository.save(email, username, passwordEncoder.encode(password), role);
    }

    private static class User extends org.springframework.security.core.userdetails.User {

        private final UserAccount account;


        public User(UserAccount acc, Collection collection) {
            super(acc.getEmail(), acc.getPassword(), collection);
            this.account = acc;
        }

        public UserAccount getAccount() {
            return account;
        }

        public boolean isAdmin() {
            return account.getIsAdmin();
        }


    }

    public UserAccount setupDefaultUsersAndRoles() {
        try {
            ROLES.forEach(role -> roleRepository.save(role, role));
        } catch (CayenneRuntimeException cex) {
            cex.getMessage();
        }
        UserAccount ua = createAccount("admin@noemail.com", "admin", "admin", Constants.ROLE_ADMIN);
        return ua;
    }

}
