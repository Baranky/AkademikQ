package com.example.BootCampProject.mapper;

import com.example.BootCampProject.dto.req.ApplicantReq;
import com.example.BootCampProject.dto.res.ApplicantRes;
import com.example.BootCampProject.entity.Applicant;

public class ApplicantMapper {

    public static ApplicantRes mapToResponse(Applicant applicant){
        ApplicantRes response=new ApplicantRes(
                applicant.getId(),
                applicant.getUsername(),
                applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getDateOfBirth(),
                applicant.getNationalIdentity(),
                applicant.getEmail(),
                applicant.getPassword(),
                applicant.getAbout()
        );
        return response;
    }

    public static Applicant mapToApplicant(ApplicantReq request){
        Applicant applicant=new Applicant();
        applicant.setUsername(request.username());
        applicant.setFirstName(request.firstName());
        applicant.setLastName(request.lastName());
        applicant.setDateOfBirth(request.dateOfBirth());
        applicant.setNationalIdentity(request.nationalIdentity());
        applicant.setEmail(request.email());
        applicant.setPassword(request.password());
        applicant.setAbout(request.about());
        return applicant;
    }
}
