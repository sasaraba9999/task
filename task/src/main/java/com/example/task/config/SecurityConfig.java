package com.example.task.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    @Bean   //@ServiceによりDIコンテナにuserDetailsか登録されているためspringが勝手に処理
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .mvcMatchers("/login/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login");

        http
                .logout()
                .logoutUrl("/logout")
                // ログアウト時の遷移先URL
                .logoutSuccessUrl("/login");

        return http.build();
    }
}