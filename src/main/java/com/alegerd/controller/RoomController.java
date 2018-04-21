package com.alegerd.controller;

import com.alegerd.model.dto.RoomDTO;
import com.alegerd.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class RoomController {

    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public RoomDTO getRoomByName(@PathVariable String name){
        return roomService.getRoomByName(name);
    }

    public void setRoomService(RoomService userService) {
        this.roomService = userService;
    }
}