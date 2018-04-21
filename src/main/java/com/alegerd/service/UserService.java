package com.alegerd.service;

import com.alegerd.dao.UserDao;
import com.alegerd.model.User;
import com.alegerd.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
/*
    @Autowired
    UserDao userDao;

    public List<UserDto> testUsers(){
        List<User> users = new ArrayList<>();
        userDao.getAll().forEach(user -> users.add(user));
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> userDtos.add(new UserDto(user.getUsername(), user.getAge())));
        return userDtos;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/
}
