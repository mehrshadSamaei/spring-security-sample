package com.example.testspringsecurity.recourse;

import com.example.testspringsecurity.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(
                Arrays.asList(
                        new User(1L, "mehrshadsamaei", "samaei", "m174", "123"),
                        new User(2L, "mehranjamalabadi", "samaei", "m172", "456")

                )
        );
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        System.out.println("usr" + user);
        return ResponseEntity.ok(
                user
        );
    }
    @GetMapping
    public ResponseEntity<Long> countAll(){
        return ResponseEntity.ok(
                new Random().nextLong();
        );
    }
}
