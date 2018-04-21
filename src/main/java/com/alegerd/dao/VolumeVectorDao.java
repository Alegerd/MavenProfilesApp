package com.alegerd.dao;

import com.alegerd.dao.generic.GenericDao;
import com.alegerd.model.VolumeVector;
import org.springframework.stereotype.Repository;

@Repository
public class VolumeVectorDao extends GenericDao<VolumeVector, Long> {

    public VolumeVectorDao() {
        super(VolumeVector.class);
    }

}
