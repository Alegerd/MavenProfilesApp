package com.alegerd.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "admission_date")
    private Date admissionDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department")
    private Department department;

    @OneToMany(mappedBy = "group")
    private Iterable<User> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Iterable<User> getStudents() {
        return students;
    }

    public void setStudents(Iterable<User> students) {
        this.students = students;
    }
}
