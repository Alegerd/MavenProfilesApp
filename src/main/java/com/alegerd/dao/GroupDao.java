package com.alegerd.dao;

import com.alegerd.model.Group;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDao extends GenericDao<Group, Long>{

    public GroupDao() {
        super(Group.class);
    }
}
