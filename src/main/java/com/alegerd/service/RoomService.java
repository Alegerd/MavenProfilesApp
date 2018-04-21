package com.alegerd.service;

import com.alegerd.dao.RoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomDao dao;

    public void setDao(RoomDao dao) {
        this.dao = dao;
    }
}
