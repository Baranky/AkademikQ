package com.example.BootCampProject.mapper;

import com.example.BootCampProject.dto.req.InstructorReq;
import com.example.BootCampProject.dto.res.InstructorRes;
import com.example.BootCampProject.entity.Instructor;

public class InstructorMapper {

    public static InstructorRes mapToResponse(Instructor instructor){
        InstructorRes response=new InstructorRes(
                instructor.getId(),
                instructor.getUsername(),
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getDateOfBirth(),
                instructor.getNationalIdentity(),
                instructor.getEmail(),
                instructor.getPassword(),
                instructor.getCompanyName()
        );
        return response;
    }
    public static Instructor mapToInstructor(InstructorReq request){
        Instructor instructor=new Instructor();
        instructor.setUsername(request.username());
        instructor.setFirstName(request.firstName());
        instructor.setLastName(request.lastName());
        instructor.setDateOfBirth(request.dateOfBirth());
        instructor.setNationalIdentity(request.nationalIdentity());
        instructor.setEmail(request.email());
        instructor.setPassword(request.password());
        instructor.setCompanyName(request.companyName());
        return instructor;
    }
}
