package com.alegerd.service;

import com.alegerd.dao.CheckInDao;
import com.alegerd.model.CheckIn;
import com.alegerd.model.dto.*;
import com.alegerd.model.dto.mappers.CheckInMapper;
import com.alegerd.util.UserProvider;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class CheckInService {

    @Autowired
    private CheckInDao dao;

    private CheckInMapper mapper;

    @Autowired
    private UserProvider userProvider;

    @Autowired
    private StudyClassService studyClassService;
    @Autowired
    private VolumeVectorService volumeVectorService;

    public enum CheckInTypes{SUCCESS, NO_CURRENT_CLASS, WRONG_ROOM}

    public void setDao(CheckInDao dao) {
        this.dao = dao;
    }

    public void setStudyClassService(StudyClassService studyClassService) {
        this.studyClassService = studyClassService;
    }

    public void setVolumeVectorService(VolumeVectorService volumeVectorService) {
        this.volumeVectorService = volumeVectorService;
    }

    public CheckInTypes tryToCheckIn(VolumeVectorDTO measuredVector) {
        UserDTO current = userProvider.getAuthenticatedUser();
        StudyClassDTO studyClassDTO = studyClassService.getCurrentSubject();
        if (studyClassDTO != null) {
            RoomDTO roomDTO = studyClassDTO.getRoom();

            VolumeVectorDTO closestVector = volumeVectorService.getClosestMatch(measuredVector);
            if (closestVector != null && closestVector.getRoom().equals(roomDTO)) {
                CheckInDTO checkInDTO = new CheckInDTO();
                java.util.Date utilDate = new java.util.Date();
                checkInDTO.setDate(new Date(utilDate.getTime()));
                checkInDTO.setStudent(current);
                checkInDTO.setStudyClass(studyClassDTO);

                CheckIn checkIn = mapper.toEntity(checkInDTO);
                dao.create(checkIn);
                return CheckInTypes.SUCCESS;
            }
            else
                return CheckInTypes.WRONG_ROOM;
        }
        return CheckInTypes.NO_CURRENT_CLASS;
    }

    public CheckInService() {
        mapper = Mappers.getMapper(CheckInMapper.class);
    }
}
