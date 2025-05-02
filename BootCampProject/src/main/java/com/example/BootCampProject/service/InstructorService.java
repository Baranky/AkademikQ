package com.example.BootCampProject.service;

import com.example.BootCampProject.dto.req.InstructorReq;
import com.example.BootCampProject.dto.res.InstructorRes;
import com.example.BootCampProject.entity.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstructorService {
    InstructorRes add(InstructorReq request);
    InstructorRes update(Long id,InstructorReq request);
    InstructorRes getById(Long id);
    List<InstructorRes> getList();
    void delete(Long id);
    Instructor findById(Long id);
}
