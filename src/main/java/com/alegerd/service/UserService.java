package com.alegerd.service;

import com.alegerd.dao.UserDao;
import com.alegerd.exceptions.UserAlreadySinedInException;
import com.alegerd.model.User;
import com.alegerd.model.dto.UserDTO;
import com.alegerd.model.dto.mappers.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    private UserMapper mapper;

    public UserService() {
        this.mapper = Mappers.getMapper(UserMapper.class);
    }

    public UserDTO findUserByUsername(String username){
        User user = dao.findByUsername(username);
        if(user == null) return null;
        else return mapper.toDto(user);
    }

    public void addUser(UserDTO userDTO){
        User user = mapper.toEntity(userDTO);
        dao.create(user);
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }
}
