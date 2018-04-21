package com.alegerd.dao;

import com.alegerd.model.CheckIn;
import org.springframework.stereotype.Repository;

@Repository
public class CheckInDao extends GenericDao<CheckIn, Long>{

    public CheckInDao(){
        super(CheckIn.class);
    }
}
