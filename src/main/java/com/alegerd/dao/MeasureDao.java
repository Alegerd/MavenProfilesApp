package com.alegerd.dao;

import com.alegerd.dao.generic.GenericDao;
import com.alegerd.model.Measure;
import org.springframework.stereotype.Repository;

@Repository
public class MeasureDao extends GenericDao<Measure, Long> {

    public MeasureDao() {
        super(Measure.class);
    }
}
