package com.alegerd.dao;

import com.alegerd.dao.generic.GenericDao;
import com.alegerd.model.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class RoomDao extends GenericDao<Room, Long> {

    public RoomDao() {
        super(Room.class);
    }

    public Room getRoomByName(String name){
        Query query = getManager().createQuery("select r from Room r where r.name=:name")
                .setParameter("name", name);
        return (Room) query.getResultList().get(0);
    }
}
