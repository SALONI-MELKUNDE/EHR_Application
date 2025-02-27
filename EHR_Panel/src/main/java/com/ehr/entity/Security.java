package com.ehr.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

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
                .httpBasic(httpBasic -> {}); // Basic Auth

        return http.build();
    }
}
