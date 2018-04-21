package com.alegerd.service;

import com.alegerd.dao.VolumeVectorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolumeVectorService {

    @Autowired
    private VolumeVectorDao dao;

    public void setDao(VolumeVectorDao dao) {
        this.dao = dao;
    }
}
