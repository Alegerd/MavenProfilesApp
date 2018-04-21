package com.alegerd.service;

import com.alegerd.dao.RoomDao;
import com.alegerd.model.Room;
import com.alegerd.model.dto.RoomDTO;
import com.alegerd.model.dto.mappers.RoomMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomDao dao;

    private RoomMapper mapper;

    public RoomService(){
        mapper = Mappers.getMapper(RoomMapper.class);
    }

    public RoomDTO getRoomByName(String name){
        Room entity = dao.getRoomByName(name);
        return mapper.toDto(entity);
    }

    public void setDao(RoomDao dao) {
        this.dao = dao;
    }
}
