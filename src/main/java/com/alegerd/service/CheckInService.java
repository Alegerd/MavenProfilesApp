package com.alegerd.service;

import com.alegerd.dao.CheckInDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckInService {

    @Autowired
    private CheckInDao dao;

    public void setDao(CheckInDao dao) {
        this.dao = dao;
    }
}
