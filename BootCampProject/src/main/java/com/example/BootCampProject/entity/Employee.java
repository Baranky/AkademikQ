package com.example.BootCampProject.entity;

import com.example.BootCampProject.core.User;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Employee  extends User {
    private  String position;

    public Employee(){

    }
    public Employee(String position) {
        this.position = position;
    }


    public Employee(Long id, String username, String firstName, String lastName, Date dateOfBirth, String nationalIdentity, String email, String password, String position) {
        super(id, username, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
