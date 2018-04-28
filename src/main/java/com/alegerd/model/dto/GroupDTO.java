package com.alegerd.model.dto;

import java.sql.Date;

public class GroupDTO {
    private Long id;
    private String name;
    private DepartmentDTO department;
    private Date admissionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupDTO(){

    }

    public GroupDTO(Long id, String name, DepartmentDTO department, Date admissionDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.admissionDate = admissionDate;
    }
}
