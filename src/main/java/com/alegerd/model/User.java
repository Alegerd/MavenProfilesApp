package com.alegerd.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User {
    private String username;
    private Integer age;
    private Integer id;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(age, that.age)
                && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, age, id);
    }
}
