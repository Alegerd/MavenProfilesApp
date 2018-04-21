package com.alegerd.model.dto;

import java.sql.Time;

public class StudyClassDTO {
    private Long id;
    private UserDTO teacher;

    private RoomDTO room;
    private Time start;
    private Time end;
    private Integer periodicity;
    private SubjectDTO subject;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(UserDTO teacher) {
        this.teacher = teacher;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public RoomDTO getRoom() {
        return room;
    }

    public void setRoom(RoomDTO room) {
        this.room = room;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public Integer getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Integer periodicity) {
        this.periodicity = periodicity;
    }

    public StudyClassDTO(){

    }

    public StudyClassDTO(Long id, UserDTO teacher, RoomDTO room, Time start, Time end, Integer periodicity, SubjectDTO subject) {
        this.id = id;
        this.teacher = teacher;
        this.room = room;
        this.start = start;
        this.end = end;
        this.periodicity = periodicity;
        this.subject = subject;
    }
}
