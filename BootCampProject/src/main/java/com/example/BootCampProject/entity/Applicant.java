package com.example.BootCampProject.entity;

import com.example.BootCampProject.core.User;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class Applicant extends User {
        private String  about ;

        @OneToMany(mappedBy = "applicant")
        private List<Application> applicationList;

        @OneToMany(mappedBy = "applicant")
        private List<Blacklist> blacklists;
        public Applicant(){

        }

        public Applicant(String about, List<Application> applicationList, List<Blacklist> blacklists) {
                this.about = about;
                this.applicationList = applicationList;
                this.blacklists = blacklists;
        }

        public Applicant(Long id, String username, String firstName, String lastName, Date dateOfBirth, String nationalIdentity, String email, String password, String about, List<Application> applicationList, List<Blacklist> blacklists) {
                super(id, username, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
                this.about = about;
                this.applicationList = applicationList;
                this.blacklists = blacklists;
        }

        public String getAbout() {
                return about;
        }

        public void setAbout(String about) {
                this.about = about;
        }

        public List<Application> getApplicationList() {
                return applicationList;
        }

        public void setApplicationList(List<Application> applicationList) {
                this.applicationList = applicationList;
        }

        public List<Blacklist> getBlacklists() {
                return blacklists;
        }

        public void setBlacklists(List<Blacklist> blacklists) {
                this.blacklists = blacklists;
        }
}
