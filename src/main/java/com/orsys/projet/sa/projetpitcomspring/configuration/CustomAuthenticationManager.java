package com.orsys.projet.sa.projetpitcomspring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@Primary
public class CustomAuthenticationManager implements AuthenticationManager {

    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;

    public CustomAuthenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        super();
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("OK dans le CustomAuthenticationManager : " + new Date() + authentication);
        return authenticationProvider().authenticate(authentication);
    }

    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);

        return authProvider;
    }
}
