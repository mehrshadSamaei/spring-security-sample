package com.example.testspringsecurity.service;

import com.example.testspringsecurity.domain.User;

public interface UserService {
    User save(User user);

    User update(User user);

    User findById(Long id);

    Long count();

    User findByName(String name);

}
