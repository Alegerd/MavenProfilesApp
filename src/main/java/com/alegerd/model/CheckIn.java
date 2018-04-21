package com.alegerd.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "check_in")
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "study_class_id")
    private StudyClass studyClass;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private User student;

    @Column(name = "date")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudyClass getStudyClass() {
        return studyClass;
    }

    public void setStudyClass(StudyClass studyClass) {
        this.studyClass = studyClass;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
