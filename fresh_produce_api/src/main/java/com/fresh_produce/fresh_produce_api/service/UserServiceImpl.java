package com.fresh_produce.fresh_produce_api.service;

import com.fresh_produce.fresh_produce_api.controllers.dto.UserDTO;
import com.fresh_produce.fresh_produce_api.repositories.UserRepository;
import com.fresh_produce.fresh_produce_api.repositories.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserDTO userDTO) {
        return null;
    }

    @Override
    public User update(UserDTO userDTO) {
        return null;
    }

    @Override
    public void delete(Integer userId) {

    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer userId) {
        return null;
    }
}
