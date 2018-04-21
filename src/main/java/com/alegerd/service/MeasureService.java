package com.alegerd.service;

import com.alegerd.dao.MeasureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasureService {

    @Autowired
    private MeasureDao dao;

    public void setDao(MeasureDao dao) {
        this.dao = dao;
    }
}
