package com.example.BootCampProject.entity;

import com.example.BootCampProject.enums.ApplicationState;
import jakarta.persistence.*;

@Entity
public final class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ApplicationState applicationState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bootcamp_id")
    private Bootcamp bootcamp;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    public Application() {
    }

    public Application(Long id, ApplicationState applicationState, Bootcamp bootcamp, Applicant applicant) {
        this.id = id;
        this.applicationState = applicationState;
        this.bootcamp = bootcamp;
        this.applicant = applicant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApplicationState getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
