package com.cinemaapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/register", "/login", "/css/**", "/images/**").permitAll() // Autorise l'accès à l'inscription, la connexion, les CSS et les images
                .anyRequest().authenticated() // Toute autre requête nécessite une authentification
            )
            .formLogin((form) -> form
                .loginPage("/login") // Page de connexion personnalisée
                .loginProcessingUrl("/login") // URL de traitement du formulaire de connexion
                .defaultSuccessUrl("/", true) // Redirection après une connexion réussie (vers l'index)
                .permitAll() // Autorise l'accès à la page de connexion
            )
            .logout((logout) -> logout
                .logoutUrl("/logout") // URL de déconnexion
                .logoutSuccessUrl("/login") // Redirection après la déconnexion
                .permitAll() // Autorise l'accès à la déconnexion
            )
            .csrf(csrf -> csrf.disable());
            
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}