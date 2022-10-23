package com.example.testspringsecurity.recourse;

import com.example.testspringsecurity.domain.Role;
import com.example.testspringsecurity.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @GetMapping
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(
                Arrays.asList(
                        new User(1L, "mehrshad"
                                , "samaei", "m74",
                                "123", Collections.singleton(new Role())),
                        new User(2L, "mehran", "samaei"
                                , "m72", "456",Collections.singleton(new Role()))

                        )
        );
    }
}
