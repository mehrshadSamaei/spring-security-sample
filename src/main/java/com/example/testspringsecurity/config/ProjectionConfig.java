package com.example.testspringsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ProjectionConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private MyAuthenticationProvider authenticationProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        var userDetailsService = new InMemoryUserDetailsManager();
//        var user = User.withUsername("mmad").password("123")
//                .authorities("read").build();
//        userDetailsService.createUser(user);
//        PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().hasAuthority("read");
//        http.authorizeRequests().anyRequest().hasAuthority("read");
//        http.authorizeRequests().anyRequest().hasAnyAuthority("read" , "write");
//        http.authorizeRequests().anyRequest().hasRole("ADMIN");
//        http.authorizeRequests().anyRequest().hasAnyRole("ADMIN" , "CUSTOMER");
        http.csrf().disable();
//        permission any request
        http.authorizeRequests().mvcMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .mvcMatchers("/customer/**")
                .hasAnyRole("ADMIN", "CUSTOMER")
                .and()
                .authorizeRequests().anyRequest()
                .authenticated();

        http.authorizeRequests().antMatchers("/customer/**" )
                .hasAnyRole("CUSTOMER" , "ADMIN");
//        http.authorizeRequests().anyRequest().authenticated();


//        http.authorizeRequests().anyRequest().authenticated();
//        http.formLogin().loginPage("login");
//custom permission
//        http.authorizeRequests().mvcMatchers(SecurityPathUtil.getAdminPaths())
//                .hasRole("ADMIN")
//                .and()
//                .authorizeRequests()
//                .mvcMatchers(SecurityPathUtil.getCustomerPaths())
//                .hasRole("CUSTOMER")
//                .and()
//                .authorizeRequests().anyRequest()
//                .authenticated();

        http.formLogin();
        http.httpBasic();
    }
// in memory
//    @Bean
//    public UserDetailsService userDetailsService() {
//        var userDetailsService = new InMemoryUserDetailsManager();
//        var user = User.withUsername("mmad").password("123")
//                .authorities("ROLE_ADMIN").build();
////                .authorities("read").build();
//        userDetailsService.createUser(user);
//        var mohesen = User.withUsername(",mohsen").password("123")
//                .authorities("ROLE_CUSTOMER").build();
////                .authorities("read").build();
//        userDetailsService.createUser(mohesen);
//        var mehrshad = User.withUsername(",mehrshad").password("123")
//                .authorities("write", "read").build();
//        userDetailsService.createUser(mohesen);
//        return userDetailsService;
//    }

//    in database


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
//        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new MyAuthenticationProvider(
                userDetailsService, passwordEncoder()
        );
    }
}
