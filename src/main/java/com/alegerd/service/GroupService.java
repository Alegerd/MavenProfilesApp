package com.alegerd.service;

import com.alegerd.dao.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    private GroupDao dao;

    public void setDao(GroupDao dao) {
        this.dao = dao;
    }
}
