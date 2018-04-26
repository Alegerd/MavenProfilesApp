package com.alegerd.controller;

import com.alegerd.exceptions.UserAlreadySinedInException;
import com.alegerd.model.dto.UserDTO;
import com.alegerd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public void addUser(@RequestBody UserDTO newUser){
        if(userService.findUserByUsername(newUser.getUsername()) == null){
            userService.addUser(newUser);
        }
    }
}
