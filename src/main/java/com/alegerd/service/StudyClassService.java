package com.alegerd.service;

import com.alegerd.dao.GroupDao;
import com.alegerd.dao.StudyClassDao;
import com.alegerd.dao.UserDao;
import com.alegerd.model.StudyClass;
import com.alegerd.model.User;
import com.alegerd.model.dto.GroupDTO;
import com.alegerd.model.dto.StudyClassDTO;
import com.alegerd.model.dto.UserDTO;
import com.alegerd.model.dto.mappers.GroupMapper;
import com.alegerd.model.dto.mappers.StudyClassMapper;
import com.alegerd.util.UserProvider;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudyClassService {

    @Autowired
    private StudyClassDao dao;

    @Autowired
    private UserService userService;

    @Autowired
    private UserProvider userProvider;

    private StudyClassMapper studyClassMapper;

    public StudyClassService() {
        this.studyClassMapper = Mappers.getMapper(StudyClassMapper.class);
    }

    @Transactional
    public List<StudyClassDTO> getSubjectsForTodayForCurrentUser(){
        List<StudyClassDTO> result = new ArrayList<>();
        UserDTO current = userProvider.getAuthenticatedUser();
        List<StudyClass> studyClasses = dao.getSubjectsForTodayForUser(current.getGroup().getId());
        studyClasses.forEach((studyClass -> result.add(studyClassMapper.toDto(studyClass))));
        return result;
    }

    @Transactional
    public StudyClassDTO getCurrentSubject(){
        UserDTO current = userProvider.getAuthenticatedUser();
        return studyClassMapper.toDto(dao.getCurrentSubjectForUser(current.getGroup().getId()));
    }

    public void setDao(StudyClassDao dao) {
        this.dao = dao;
    }
}
