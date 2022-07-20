package com.fresh_produce.fresh_produce_api.service;

import com.fresh_produce.fresh_produce_api.controllers.dto.UserDTO;
import com.fresh_produce.fresh_produce_api.repositories.entities.User;

public interface UserService {
    User save(UserDTO userDTO);
    User update(UserDTO userDTO);
    void delete(Integer userId);
    Iterable<User> findAll();
    User findById(Integer userId);
    User findByEmail(String email);

    User signIn(String email, String password);
}


