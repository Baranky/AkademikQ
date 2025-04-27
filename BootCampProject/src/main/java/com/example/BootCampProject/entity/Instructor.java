package com.example.BootCampProject.entity;

import com.example.BootCampProject.core.User;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Instructor extends User {
    private  String companyName;
    public Instructor(){

    }

    public Instructor(String companyName) {
        this.companyName = companyName;
    }

    public Instructor(Long id, String username, String firstName, String lastName, Date dateOfBirth, String nationalIdentity, String email, String password, String companyName) {
        super(id, username, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}