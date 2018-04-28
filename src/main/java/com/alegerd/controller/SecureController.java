package com.alegerd.controller;

import com.alegerd.exceptions.WrongLoginException;
import com.alegerd.model.StudyClass;
import com.alegerd.model.dto.RoomDTO;
import com.alegerd.model.dto.StudyClassDTO;
import com.alegerd.model.dto.UserDTO;
import com.alegerd.service.GroupService;
import com.alegerd.service.RoomService;
import com.alegerd.service.StudyClassService;
import com.alegerd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping(value = "/api/secure")
public class SecureController {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private StudyClassService studyClassService;

    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    @ResponseBody
    public UserDTO getCurrentUser() throws WrongLoginException {
        return userService.getCurrentUser();
    }

    @RequestMapping(value = "/gsft", method = RequestMethod.GET)
    @ResponseBody
    public List<StudyClassDTO> getSubjectsForTodayForCurrentUser() {
        return studyClassService.getSubjectsForTodayForCurrentUser();
    }

    @RequestMapping(value = "/gcs", method = RequestMethod.GET)
    @ResponseBody
    public StudyClassDTO getCurrentSubject() {
        return studyClassService.getCurrentSubject();
    }

}