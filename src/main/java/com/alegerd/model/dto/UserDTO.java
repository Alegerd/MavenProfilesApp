package com.alegerd.model.dto;

import java.sql.Date;

public class UserDTO {
    private Long id;
    private String username;
    private String fullName;
    private GroupDTO group;
    private UserRoleDTO role;
    private Date birthday;
    private Double rating;
    private String personalInfo;
    private String contacts;
    private String password;

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

    public void setGroup(GroupDTO _group) {
        this.group = _group;
    }

    public UserRoleDTO getRole() {
        return role;
    }

    public void setRole(UserRoleDTO role) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDTO(){

    }

    public UserDTO(Long id, String username,String fullName, GroupDTO group, UserRoleDTO role, Date birthday, Double rating, String personalInfo, String contacts, String password) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.group = group;
        this.role = role;
        this.birthday = birthday;
        this.rating = rating;
        this.personalInfo = personalInfo;
        this.contacts = contacts;
    }
}
