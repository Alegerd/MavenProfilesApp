package com.alegerd.dao;

import com.alegerd.dao.generic.GenericDao;
import com.alegerd.model.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDao extends GenericDao<UserRole, Long> {

    public UserRoleDao() {
        super(UserRole.class);
    }

}
