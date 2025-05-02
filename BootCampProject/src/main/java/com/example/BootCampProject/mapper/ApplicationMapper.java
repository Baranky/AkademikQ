package com.example.BootCampProject.mapper;

import com.example.BootCampProject.dto.req.ApplicationReq;
import com.example.BootCampProject.dto.res.ApplicationRes;
import com.example.BootCampProject.entity.Applicant;
import com.example.BootCampProject.entity.Application;
import com.example.BootCampProject.entity.Bootcamp;

public class ApplicationMapper {
    public static ApplicationRes mapToResponse (Application application){
        return new ApplicationRes(
                application.getId(),
                application.getApplicationState(),
                application.getBootcamp().getId(),
                application.getApplicant().getId());
    }
    public static Application mapToApplication(ApplicationReq request, Applicant applicant, Bootcamp bootcamp){
        Application application=new Application();
        application.setApplicant(applicant);
        application.setApplicationState(request.applicationState());
        application.setBootcamp(bootcamp);
        return application;
    }
}
