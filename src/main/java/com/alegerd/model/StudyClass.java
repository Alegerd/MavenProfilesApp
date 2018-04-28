package com.alegerd.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

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

    @Column(name = "finish")
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
    private Collection<GroupEntity> groups;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinTable(name = "study_class_in_week_day",
            joinColumns = @JoinColumn(name = "study_class_id"),
            inverseJoinColumns = @JoinColumn(name = "week_day_id")
    )
    private Collection<WeekDay> days;

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

    public Collection<GroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(Collection<GroupEntity> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyClass that = (StudyClass) o;
        return id == that.id
                && Objects.equals(teacher, that.teacher)
                && Objects.equals(subject, that.subject)
                && Objects.equals(start, that.start)
                && Objects.equals(end, that.end)
                && Objects.equals(periodicity, that.periodicity)
                && Objects.equals(groups, that.groups)
                && Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teacher, subject, start, end, periodicity, groups, room);
    }
}
