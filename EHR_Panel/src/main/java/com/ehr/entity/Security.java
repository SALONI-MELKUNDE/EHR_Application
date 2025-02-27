package com.ehr.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity

public class Security {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/addPatients").hasRole("ADMIN")
                        .requestMatchers("/getAllDoctorRecords").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/doctor/**").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/SelfVitalsRecords").hasRole("PATIENT")
                        .requestMatchers("/getAllPatients").hasRole("ADMIN")
                        .requestMatchers("/patient/**").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/addDoctors").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {
                });

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("admin123")  // We'll encode later
                .roles("ADMIN")
                .build();

        UserDetails doctor = User.builder()
                .username("doctor1")
                .password("doctor123") // We'll encode later
                .roles("DOCTOR")
                .build();

        UserDetails patient = User.builder()
                .username("patient1")
                .password("patient123") // We'll encode later
                .roles("PATIENT")
                .build();

        return new InMemoryUserDetailsManager(admin, doctor, patient);
    }

}

