package com.alegerd.service;

import com.alegerd.dao.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleDao dao;

    public void setDao(UserRoleDao dao) {
        this.dao = dao;
    }
}
