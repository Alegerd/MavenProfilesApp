package com.alegerd.controller;

import com.alegerd.model.dto.UserDto;
import com.alegerd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

   /* @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }

    @ModelAttribute("users")
    public List<UserDto> getUsers(){
        return userService.testUsers();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/
}
