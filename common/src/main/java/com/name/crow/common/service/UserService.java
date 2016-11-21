package com.name.crow.common.service;

import com.name.crow.common.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by pchandramohan on 11/20/16.
 */
public interface UserService extends UserDetailsService {

    public User create(String email, String username, String password, String role);

}
