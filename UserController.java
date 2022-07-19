package com.fresh_produce.fresh_produce_api.controllers;

import com.fresh_produce.fresh_produce_api.controllers.dto.UserDTO;
import com.fresh_produce.fresh_produce_api.repositories.entities.User;
import com.fresh_produce.fresh_produce_api.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public Iterable<User> getAll(){
        return userService.findAll();
    }

    @CrossOrigin
    @PostMapping("/signup")
    public User signUp(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }
//    @CrossOrigin
//    @PostMapping("/signin")
//    public User signIn(@RequestBody UserDTO userDTO){
//        return userService.findById()
//    }

}