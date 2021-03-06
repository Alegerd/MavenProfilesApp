package com.alegerd.controller;

import com.alegerd.model.dto.UserDTO;
import com.alegerd.service.GroupService;
import com.alegerd.service.StudyClassService;
import com.alegerd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/api/free")
public class FreeController {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private StudyClassService studyClassService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public void addUser(@RequestBody UserDTO newUser){
        if(userService.findUserByUsername(newUser.getUsername()) == null){
            userService.addUser(newUser);
        }
    }

    @RequestMapping(value = "/gasig/{groupId}", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDTO> getAllStudentsInGroup(@PathVariable Long groupId){
        return groupService.getAllStudentsInGroupById(groupId);
    }

    /*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity loginUser(@RequestParam String username, String password) throws WrongLoginException{
        userService.loginUser(username, password);
        return ResponseEntity.ok().build();
    }
    */


    @RequestMapping(value = "/kek", method = RequestMethod.POST)
    public void kek(RequestEntity requestEntity){
       String s = requestEntity.toString();
    }

    @RequestMapping(value = "/gasidoc", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDTO> getAllStudentsInDepartmentOnCourse(@RequestParam Long depId, @RequestParam Integer courseNum){
        return groupService.getAllStudentsInDepartmentOnCourse(depId, courseNum);
    }

    @RequestMapping(value = "/gasid/{depId}", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDTO> getAllStudentsInDepartment(@PathVariable Long depId){
        return groupService.getAllStudentsInDepartment(depId);
    }
}
