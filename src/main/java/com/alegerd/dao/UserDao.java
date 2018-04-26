package com.alegerd.dao;

import com.alegerd.dao.generic.GenericDao;
import com.alegerd.model.User;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;

@Repository
public class UserDao extends GenericDao<User, Long> {

    public UserDao() {
        super(User.class);
    }

    public User findByUsername(String username) {
        User result = (User) getManager().createQuery("select u from User u where u.username=:username")
                .setParameter("username", username).getSingleResult();
        return result;
    }
}