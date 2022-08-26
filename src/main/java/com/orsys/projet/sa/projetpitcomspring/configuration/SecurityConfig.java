package com.orsys.projet.sa.projetpitcomspring.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {;
        http.csrf().disable()
                .authenticationManager(new CustomAuthenticationManager(userDetailsService, passwordEncoder))
                .formLogin()
                .loginPage("/authentication")
                .defaultSuccessUrl("/annonces")
                .failureForwardUrl("/inscription")
                .and()
                .logout()
                .logoutUrl("/deconnexion")
                .logoutSuccessUrl("/authentication")
                .and()
                .authorizeRequests()
                .antMatchers("/h2-console").permitAll()
                .antMatchers("/inscription").authenticated()
                .antMatchers("/authentication").authenticated()
                // Pour la console H2 (à ne pas utiliser en prod)
                .and()
                .headers().frameOptions().disable();
        return http.build();
    }

}
