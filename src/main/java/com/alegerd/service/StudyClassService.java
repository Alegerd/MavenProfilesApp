package com.alegerd.service;

import com.alegerd.dao.StudyClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyClassService {

    @Autowired
    private StudyClassDao dao;

    public void setDao(StudyClassDao dao) {
        this.dao = dao;
    }
}
