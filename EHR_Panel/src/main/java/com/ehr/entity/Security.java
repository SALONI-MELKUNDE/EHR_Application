package com.ehr.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/addPatients").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/patient/**").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/getAllPatients").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/patientDelete/**").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/patientUpdate/**").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/addDoctors").hasAnyRole("ADMIN", "PATIENT")
                        .requestMatchers("/getAllDoctorRecords").hasAnyRole("ADMIN", "PATIENT")
                        .requestMatchers("/doctor/**").hasAnyRole("ADMIN", "PATIENT")
                        .requestMatchers("/doctorDelete/**").hasAnyRole("ADMIN", "PATIENT")
                        .requestMatchers("/doctorUpdate/**").hasAnyRole("ADMIN", "PATIENT")
                        .requestMatchers("/SelfVitalsRecords").hasAnyRole("ADMIN", "PATIENT")
                        .requestMatchers("/getAllSelfVitalsRecords").hasAnyRole("ADMIN", "PATIENT")
                        .requestMatchers("/getSelfVitalRecordsByPatient/**").hasAnyRole("ADMIN", "PATIENT")
                        .requestMatchers("/deleteSelfVitalsRecords/**").hasAnyRole("ADMIN", "PATIENT")
                        .requestMatchers("/updateSelfVitalsRecords/**").hasAnyRole("ADMIN", "PATIENT")
                        .requestMatchers("/prescription").hasAnyRole("ADMIN", "PATIENT")
                        .requestMatchers("/getPrescription").hasAnyRole("ADMIN","PATIENT")
                        .requestMatchers("/prescription/**").hasAnyRole("ADMIN", "PATIENT")
                        .requestMatchers("/deletePrescription/**").hasAnyRole("ADMIN", "PATIENT")
                        .requestMatchers("/addAppointment").hasAnyRole("ADMIN", "DOCTOR", "PATIENT")
                        .requestMatchers("/allAppointment").hasAnyRole("ADMIN", "PATIENT",  "DOCTOR")
                        .requestMatchers("/appointment/**").hasAnyRole("ADMIN", "PATIENT", "DOCTOR")


                )
                .httpBasic(httpBasic -> {}); // Use correct syntax for HTTP Basic Auth

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails doctor = User.builder()
                .username("doctor1")
                .password(passwordEncoder().encode("doctor123"))
                .roles("DOCTOR")
                .build();

        UserDetails patient = User.builder()
                .username("patient1")
                .password(passwordEncoder().encode("patient123"))
                .roles("PATIENT")
                .build();

        return new InMemoryUserDetailsManager(admin, doctor, patient);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

