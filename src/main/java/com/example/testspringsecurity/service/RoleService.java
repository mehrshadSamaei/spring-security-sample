package com.example.testspringsecurity.service;

import com.example.testspringsecurity.domain.Role;
import com.example.testspringsecurity.domain.User;

public interface RoleService {
    Role save(Role role);
    Role findById(Long id);
    Long count();
    Role findByName(String name);
}
