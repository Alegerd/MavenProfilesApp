package com.alegerd.service;

import com.alegerd.dao.GroupDao;
import com.alegerd.model.dto.UserDTO;
import com.alegerd.model.dto.mappers.GroupMapper;
import com.alegerd.model.dto.mappers.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupDao dao;

    private GroupMapper mapper;

    private UserMapper userMapper;

    public GroupService() {
        this.mapper = Mappers.getMapper(GroupMapper.class);
        this.userMapper = Mappers.getMapper(UserMapper.class);
    }

    public void setDao(GroupDao dao) {
        this.dao = dao;
    }

    @Transactional
    public List<UserDTO> getAllStudentsInGroupById(Long groupId){

        List<UserDTO> result = new ArrayList<>();
        dao.getAllStudentsInGroupById(groupId).forEach(student -> {result.add(userMapper.toDto(student));});
        return result;
    }

    @Transactional
    public List<UserDTO> getAllStudentsInDepartment(Long depId){

        List<UserDTO> result = new ArrayList<>();
        dao.getAllStudentsInDepartment(depId).forEach(student -> {result.add(userMapper.toDto(student));});
        return result;
    }

    @Transactional
    public List<UserDTO> getAllStudentsInDepartmentOnCourse(Long depId, Integer courseNum){
        List<UserDTO> result = new ArrayList<>();
        Date finish = new Date();
        Date start = new Date();
        start.setMonth(7);
        finish.setMonth(7);
        start.setDate(31);
        finish.setDate(31);
        int year = start.getYear();
        year = year - courseNum;
        start.setYear(year);
        finish.setYear(year+1);
        dao.getAllStudentsInDepartmentOnCourse(depId, start, finish).forEach(student -> {result.add(userMapper.toDto(student));});
        return result;
    }
}
