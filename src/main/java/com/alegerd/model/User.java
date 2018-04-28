package com.alegerd.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="_group")
    private GroupEntity group;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="role")
    private UserRole role;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "personal_info")
    private String personalInfo;

    @Column(name = "contacts")
    private String contacts;

    @Column(name = "password")
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

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id
                && Objects.equals(username, that.username)
                && Objects.equals(fullName, that.fullName)
                && Objects.equals(group, that.group)
                && Objects.equals(role, that.role)
                && Objects.equals(birthday, that.birthday)
                && Objects.equals(rating, that.rating)
                && Objects.equals(personalInfo, that.personalInfo)
                && Objects.equals(contacts, that.contacts)
                && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, fullName, group, role, birthday, rating, personalInfo, contacts);
    }
}
