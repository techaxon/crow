//package com.name.crow.bck;
//
//import com.name.crow.web.service.UserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.StandardPasswordEncoder;
//
///**
// * Created by pchandramohan on 11/20/16.
// */
//
//@Configuration
//public class CrowSecurityConfig extends WebSecurityConfigurerAdapter{
//
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
//    }
//
//
//
//
//    @Bean
//    public UserService userService() {
//        return new UserService();
//    }
//
////    @Bean
////    public TokenBasedRememberMeServices rememberMeServices() {
////        return new TokenBasedRememberMeServices("remember-me-key", userService());
////    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new StandardPasswordEncoder();
//    }
//
//}
