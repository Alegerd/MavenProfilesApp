package com.alegerd.service;

import com.alegerd.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao dao;

    public void setDao(DepartmentDao dao) {
        this.dao = dao;
    }
}
