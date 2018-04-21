package com.alegerd.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;

@Entity
@Table(name = "study_class")
public class StudyClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher")
    private User teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room")
    private Room room;

    @Column(name = "start")
    private Time start;

    @Column(name = "end")
    private Time end;

    @Column(name = "periodicity")
    private Integer periodicity;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinTable(name = "group_in_study_class",
            joinColumns = @JoinColumn(name = "study_class_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Collection<Group> groups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
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

    public Collection<Group> getGroups() {
        return groups;
    }

    public void setGroups(Collection<Group> groups) {
        this.groups = groups;
    }
}
