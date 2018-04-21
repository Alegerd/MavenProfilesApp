package com.alegerd.model.dto;

import java.sql.Date;

public class GroupDTO {
    private Long id;
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

    public GroupDTO(){

    }

    public GroupDTO(Long id, DepartmentDTO department, Date admissionDate) {
        this.id = id;
        this.department = department;
        this.admissionDate = admissionDate;
    }
}
