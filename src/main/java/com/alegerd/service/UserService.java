package com.alegerd.service;

import com.alegerd.dao.UserDao;
import com.alegerd.exceptions.UserAlreadySinedInException;
import com.alegerd.exceptions.WrongLoginException;
import com.alegerd.model.User;
import com.alegerd.model.dto.UserDTO;
import com.alegerd.model.dto.mappers.UserMapper;
import com.alegerd.util.SecurityService;
import com.alegerd.util.UserProvider;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserProvider userProvider;

    @Autowired
    private BCryptPasswordEncoder encoder;

    private UserMapper mapper;

    public UserService() {
        this.mapper = Mappers.getMapper(UserMapper.class);
    }

    @Transactional
    public UserDTO findUserByUsername(String username){
        User user = dao.findByUsername(username);
        if(user == null) return null;
        else return mapper.toDto(user);
    }

    @Transactional
    public void addUser(UserDTO userDTO){
        User user = mapper.toEntity(userDTO);
        user.setPassword(encoder.encode(user.getPassword()));
        dao.create(user);
    }

    @Transactional
    public String loginUser(String username, String password) throws WrongLoginException{
        UserDTO user = findUserByUsername(username);
        if(user == null) throw new WrongLoginException();
        else {
            if(!encoder.matches(password, user.getPassword())) throw new WrongLoginException();
            else {
                securityService.loginUser(username, password);
                return "auth_token";  //TODO token
            }
        }
    }

    @Transactional
    public UserDTO getCurrentUser() throws WrongLoginException{
        UserDTO current = userProvider.getAuthenticatedUser();
        if(current == null) throw new WrongLoginException();
        else return current;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }
}
