package com.fresh_produce.fresh_produce_api.service;

import com.fresh_produce.fresh_produce_api.controllers.dto.UserDTO;
import com.fresh_produce.fresh_produce_api.repositories.UserRepository;
import com.fresh_produce.fresh_produce_api.repositories.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserDTO userDTO) {
        // check if the username unique

        User userFromDb =userRepository.findByEmail(userDTO.getEmail());
        if(userFromDb == null){
            return userRepository.save(new User(userDTO));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Email was registered. Please sign in or use a new email");
        }

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

    @Override
    public User findByEmail(String email) {
        //check for email
        User userFromDb =userRepository.findByEmail(email);
        if(userFromDb == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not registered");}
        return userFromDb;
    }

    public User signIn(String email, String password){
        User userFromDb = userRepository.findByEmail(email);
        System.out.println(userFromDb.getPassword());
        System.out.println(password);
        if((userFromDb != null) && (userFromDb.getPassword() == password)) {
                return userFromDb;
            }
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Password is not a match " + userFromDb);

    }

}
