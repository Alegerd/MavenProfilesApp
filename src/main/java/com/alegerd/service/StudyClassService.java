package com.alegerd.service;

import com.alegerd.dao.StudyClassDao;
import com.alegerd.model.StudyClass;
import com.alegerd.model.dto.StudyClassDTO;
import com.alegerd.model.dto.UserDTO;
import com.alegerd.model.dto.mappers.StudyClassMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;

@Service
public class StudyClassService {

    @Autowired
    private StudyClassDao dao;

    private StudyClassMapper mapper;

    public void setDao(StudyClassDao dao) {
        this.dao = dao;
    }

    public StudyClassDTO getCurrentClassForUser(UserDTO userDTO){
        Long groupId = userDTO.getGroup().getId();
        //У нас в entity используется Time, а он хранит и день, и год,и тд.
        //LocalTime хранит только время
        //Надо придумать как из таблцицы доставать уроки сравнивая только по времени
        Time time = new Time(new java.util.Date().getTime());
        LocalTime localTime = time.toLocalTime();
        int periodicity = 0; //нужно придумать как определять числитель ли сейчас или знаменатель
        int dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        //TODO достать через DAO урок который в данный момент идёт у данной группы
        StudyClass studyClass = dao.getClassByGroupIdAndDateAndTime(groupId, dayOfWeek, localTime, periodicity);
        return mapper.toDto(studyClass);
    }

    public StudyClassService(){
        this.mapper= Mappers.getMapper(StudyClassMapper.class);
    }
}
