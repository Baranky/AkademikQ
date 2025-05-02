package com.example.BootCampProject.service;

import com.example.BootCampProject.dto.req.ApplicantReq;
import com.example.BootCampProject.dto.res.ApplicantRes;
import com.example.BootCampProject.entity.Applicant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ApplicantService {
    ApplicantRes add(ApplicantReq request);
    ApplicantRes update(Long id,ApplicantReq request);
    ApplicantRes getById(Long id);
    List<ApplicantRes> getList();
    void delete(Long id);

    Applicant findById(Long id);
}
