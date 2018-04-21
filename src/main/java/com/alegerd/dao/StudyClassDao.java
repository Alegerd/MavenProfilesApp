package com.alegerd.dao;

import com.alegerd.dao.generic.GenericDao;
import com.alegerd.model.StudyClass;
import org.springframework.stereotype.Repository;

@Repository
public class StudyClassDao extends GenericDao<StudyClass, Long> {

    public StudyClassDao() {
        super(StudyClass.class);
    }

}
