package com.example.testspringsecurity.service.impl;

import com.example.testspringsecurity.domain.User;
import com.example.testspringsecurity.repository.UserRepository;
import com.example.testspringsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Long count() {
        return userRepository.count();
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
