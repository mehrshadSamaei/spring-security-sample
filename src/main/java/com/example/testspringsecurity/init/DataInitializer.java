package com.example.testspringsecurity.init;

import com.example.testspringsecurity.domain.Role;
import com.example.testspringsecurity.domain.User;
import com.example.testspringsecurity.service.RoleService;
import com.example.testspringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;


@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void DataInitializer() {
        initRoles();
        initUsers();
    }

    private void initUsers() {
        if (userService.count() == 0 && roleService.count() != 0){
            Role admin = roleService.findByName("ADMIN");
            Role customer = roleService.findByName("CUSTOMER");

            userService.save(
                    new User(null , "mwhrshad" , "samei"
                            , "m74" , passwordEncoder.encode("fasd") , Collections.singleton(admin))
            );
            userService.save(
                    new User(null , "mw" , "samei"
                            , "m7asd4" , "74asd 1"
                            ,Collections.singleton(customer))
            );
        }
    }

    private void initRoles() {
        if (roleService.count() == 0){
            roleService.save(new Role(null , "ADMIN"));
            roleService.save(new Role(null , "CUSTOMER"));
        }
    }
}
