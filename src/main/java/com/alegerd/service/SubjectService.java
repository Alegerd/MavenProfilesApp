package com.alegerd.service;

import com.alegerd.dao.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private SubjectDao dao;

    public void setDao(SubjectDao dao) {
        this.dao = dao;
    }
}
