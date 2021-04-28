package com.upgrad.userdetails.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "email" ,unique = true)
    private String email;

    @Column(name = "phonenum" ,unique = true)
    private String phonenum;

    // RELATIONSHIPS
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Detail> phone = new ArrayList<>();

    // GETTERS AND SETTERS

    public List<Detail> getPosts() {
        return phone;
    }

    public void setPosts(List<Detail> posts) {
        this.phone = posts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
}
