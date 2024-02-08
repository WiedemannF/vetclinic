package com.javajunior.vetclinic.vetservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private static String USERNAME = "test";
    private static String PASSWORD = "test";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> requests
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

        @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder()
                .username(USERNAME)
                .password(bCryptPasswordEncoder.encode(PASSWORD))
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }
}
