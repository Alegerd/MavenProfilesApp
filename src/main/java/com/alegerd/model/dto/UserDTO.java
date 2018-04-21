package com.alegerd.model.dto;

import java.sql.Date;

public class UserDTO {
    private Long id;
    private String fullName;
    private GroupDTO group;
    private String role;
    private Date birthday;
    private Double rating;
    private String personalInfo;
    private String contacts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO group) {
        this.group = group;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(String personalInfo) {
        this.personalInfo = personalInfo;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
