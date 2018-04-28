package com.alegerd.dao;

import com.alegerd.dao.generic.GenericDao;
import com.alegerd.model.StudyClass;
import com.alegerd.util.CurrentWeekDayProvider;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Repository
public class StudyClassDao extends GenericDao<StudyClass, Long> {

    public StudyClassDao() {
        super(StudyClass.class);
    }

    public List<StudyClass> getSubjectsForTodayForUser(Long groupId){

        String weekDayName = CurrentWeekDayProvider.getCurrentWeekDay();

        List<StudyClass> studyClasses = getManager().createQuery("select s from StudyClass s join s.days d join fetch s.groups g where d.name like :day and g.id=:id")
                .setParameter("day", weekDayName)
                .setParameter("id", groupId)
                .getResultList();
        return studyClasses;
    }

    public StudyClass getCurrentSubjectForUser(Long groupId){

        String weekDayName = CurrentWeekDayProvider.getCurrentWeekDay();

        Time time = new Time(new Date().getTime());

        List<StudyClass> studyClasses = getManager().createQuery("select s from StudyClass s join s.days d join fetch s.groups g where d.name like :day and g.id=:id and :time between s.start and s.end")
                .setParameter("day", weekDayName)
                .setParameter("id", groupId)
                .setParameter("time", time)
                .getResultList();

        if(studyClasses.size() > 0)
            return studyClasses.get(0);
        else return null;
    }
}
