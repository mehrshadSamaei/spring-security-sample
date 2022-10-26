package com.example.testspringsecurity.config2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.cert.Extension;

@Configuration
@EnableWebSecurity
public class ConfigurationSpringSecurity {
    @Bean
    public InMemoryUserDetailsManager userDetailService() {
        UserDetails user1 = User.withUsername("m74").password(passwordEncoder().encode("123"))
                .roles("USER").build();
        UserDetails admin = User.withUsername("m72").password(passwordEncoder().encode("1374"))
                .roles("ROLE_ADMIN").build();
        UserDetails user2 = User.withUsername("s12").password(passwordEncoder().encode("159"))
                .roles("USER").build();
        return new InMemoryUserDetailsManager(user1, user2 , admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/anonymous*")
                .anonymous().antMatchers("/login*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("login.html")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/homepage.html" , true)
                .failureHandler(authenticationFailureHandler())
                .and().logout().logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler());
        return httpSecurity.build();

    }
}
