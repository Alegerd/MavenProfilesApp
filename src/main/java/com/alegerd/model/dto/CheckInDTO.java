package com.alegerd.model.dto;

import java.sql.Date;

public class CheckInDTO {
    private Long id;
    private StudyClassDTO studyClass;
    private UserDTO student;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudyClassDTO getStudyClass() {
        return studyClass;
    }

    public void setStudyClass(StudyClassDTO studyClass) {
        this.studyClass = studyClass;
    }

    public UserDTO getStudent() {
        return student;
    }

    public void setStudent(UserDTO student) {
        this.student = student;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
