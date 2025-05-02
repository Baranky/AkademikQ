package com.example.BootCampProject.entity;

import com.example.BootCampProject.core.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class Instructor extends User {
    private String companyName;

    @OneToMany(mappedBy = "instructor")
    private List<Bootcamp> bootcampList;

    public Instructor() {

    }

    public Instructor(String companyName, List<Bootcamp> bootcampList) {
        this.companyName = companyName;
        this.bootcampList = bootcampList;
    }

    public Instructor(Long id, String username, String firstName, String lastName, Date dateOfBirth, String nationalIdentity, String email, String password, String companyName, List<Bootcamp> bootcampList) {
        super(id, username, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.companyName = companyName;
        this.bootcampList = bootcampList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Bootcamp> getBootcampList() {
        return bootcampList;
    }

    public void setBootcampList(List<Bootcamp> bootcampList) {
        this.bootcampList = bootcampList;
    }
}