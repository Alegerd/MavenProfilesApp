package com.alegerd.dao;

import com.alegerd.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDao extends GenericDao<User, Integer> {

    public UserDao() {
        super(User.class);
    }

    public List<User> getAll(){
        Query query = getManager().createQuery("select u from User u");
        return query.getResultList();
    }
}