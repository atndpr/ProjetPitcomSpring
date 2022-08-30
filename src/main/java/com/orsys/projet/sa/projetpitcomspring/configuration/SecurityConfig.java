package com.orsys.projet.sa.projetpitcomspring.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                /*.authorizeRequests()
                .antMatchers("/api/**").permitAll();*/

                .authenticationManager(new CustomAuthenticationManager(userDetailsService, passwordEncoder))
                .formLogin()
                .loginPage("/api/authentication")
                .loginProcessingUrl("/api/authentication")
                .defaultSuccessUrl("/api/client/annonces")
                .failureForwardUrl("/api/inscription")
                .and()
                .logout()
                .logoutSuccessUrl("/api/authentication")
                .and()
                .authorizeRequests()
                .antMatchers("/h2-console").permitAll()
                .antMatchers("/swagger-ui").permitAll()
                .antMatchers("/admin/annonces").permitAll()
                .antMatchers("/client/annonce").permitAll()
                .antMatchers("/api/inscription").authenticated()
                .antMatchers("/api/authentication").authenticated()
                // Pour la console H2 (à ne pas utiliser en prod)
                .and()
                .headers().frameOptions().disable();
        return http.build();
    }

}
