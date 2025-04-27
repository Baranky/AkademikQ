package com.example.BootCampProject.entity;

import com.example.BootCampProject.core.User;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Applicant extends User {
        private String  about ;
        public Applicant(){

        }

        public Applicant(String about) {
                this.about = about;
        }

        public Applicant(Long id, String username, String firstName, String lastName, Date dateOfBirth, String nationalIdentity, String email, String password, String about) {
                super(id, username, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
                this.about = about;
        }

        public String getAbout() {
                return about;
        }

        public void setAbout(String about) {
                this.about = about;
        }

}
