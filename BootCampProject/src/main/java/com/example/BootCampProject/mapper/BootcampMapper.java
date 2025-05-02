package com.example.BootCampProject.mapper;

import com.example.BootCampProject.dto.req.BootcampReq;
import com.example.BootCampProject.dto.res.BootcampRes;
import com.example.BootCampProject.entity.Bootcamp;
import com.example.BootCampProject.entity.Instructor;

public class BootcampMapper {
    public static BootcampRes mapToResponse(Bootcamp bootcamp){
        return new BootcampRes(
                bootcamp.getId(),
                bootcamp.getName(),
                bootcamp.getStartDate(),
                bootcamp.getEndDate(),
                bootcamp.getBootcampState(),
                bootcamp.getInstructor().getId()
        );

    }
    public static Bootcamp mapToBootcamp(BootcampReq request, Instructor instructor){
        Bootcamp bootcamp=new Bootcamp();
        bootcamp.setBootcampState(request.bootcampState());
        bootcamp.setEndDate(request.endDate());
        bootcamp.setStartDate(request.startDate());
        bootcamp.setName(request.name());
        bootcamp.setInstructor(instructor);
        return bootcamp;

    }
}
