package com.alegerd.dao;

import com.alegerd.dao.generic.GenericDao;
import com.alegerd.model.StudyClass;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.Time;
import java.time.LocalTime;

@Repository
public class StudyClassDao extends GenericDao<StudyClass, Long> {

    public StudyClassDao() {
        super(StudyClass.class);
    }

    public StudyClass getClassByGroupIdAndDateAndTime(Long groupId, int dayOfWeek, LocalTime currentTime, int periodicity){
        //TODO достать через DAO урок который в данный момент идёт у данной группы
        return null;
    }

}
