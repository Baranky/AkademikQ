package com.example.BootCampProject.entity;

import com.example.BootCampProject.enums.BootcampState;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Bootcamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private BootcampState bootcampState;

    @OneToMany(mappedBy = "bootcamp")
    private List<Application> applicationList ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public Bootcamp() {

    }

    public Bootcamp(Long id, String name, LocalDateTime startDate, LocalDateTime endDate, BootcampState bootcampState, List<Application> applicationList, Instructor instructor) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bootcampState = bootcampState;
        this.applicationList = applicationList;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public BootcampState getBootcampState() {
        return bootcampState;
    }

    public void setBootcampState(BootcampState bootcampState) {
        this.bootcampState = bootcampState;
    }

    public List<Application> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
