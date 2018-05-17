package com.alegerd.controller;

import com.alegerd.exceptions.WrongLoginException;
import com.alegerd.model.dto.RoomDTO;
import com.alegerd.model.dto.StudyClassDTO;
import com.alegerd.model.dto.UserDTO;
import com.alegerd.model.dto.VolumeVectorDTO;
import com.alegerd.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private VolumeVectorService volumeVectorService;

    @Autowired
    CheckInService checkInService;

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

    @RequestMapping(value = "/whereami", method = RequestMethod.POST)
    @ResponseBody
    public RoomDTO whereAmI(@RequestBody VolumeVectorDTO measuredVector) {
        VolumeVectorDTO volumeVectorDTO = volumeVectorService.getClosestMatch(measuredVector);
        if(volumeVectorDTO!=null) {
            RoomDTO roomDTO = volumeVectorDTO.getRoom();
            return roomDTO;
        }
        else
            return null;
    }

    @RequestMapping(value = "/checkIn", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity checkIn(@RequestBody VolumeVectorDTO measuredVector) {
        CheckInService.CheckInTypes res = checkInService.tryToCheckIn(measuredVector);
        switch (res) {
            case SUCCESS:
                return ResponseEntity.ok().build();
            case WRONG_ROOM:
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            case NO_CURRENT_CLASS:
                return ResponseEntity.notFound().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/savemeasures/{room}/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity saveMeasures(@PathVariable String room, @RequestBody VolumeVectorDTO measuredVector) {
        try {
            volumeVectorService.saveMeasures(measuredVector, room);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/gcs", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getCurrentSubject() {
        StudyClassDTO dto = studyClassService.getCurrentSubject();
        if (dto != null)
            return ResponseEntity.ok(dto);
        else
            return ResponseEntity.badRequest().build();
    }

}