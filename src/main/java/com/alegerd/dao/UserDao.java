package com.alegerd.dao;

import com.alegerd.dao.generic.GenericDao;
import com.alegerd.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends GenericDao<User, Long> {

    public UserDao() {
        super(User.class);
    }
}