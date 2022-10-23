package com.example.testspringsecurity.service.impl;

import com.example.testspringsecurity.domain.Role;
import com.example.testspringsecurity.repository.RoleRepository;
import com.example.testspringsecurity.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public Role findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public Role findByName(String name) {
        return repository.findByName(name);
    }
}
