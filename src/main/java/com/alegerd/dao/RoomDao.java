package com.alegerd.dao;

import com.alegerd.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDao extends GenericDao<Room, Long>{

    public RoomDao() {
        super(Room.class);
    }
}
