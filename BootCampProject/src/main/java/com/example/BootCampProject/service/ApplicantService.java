package com.example.BootCampProject.service;

import com.example.BootCampProject.dto.req.ApplicantReq;
import com.example.BootCampProject.dto.res.ApplicantRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicantService {
    ApplicantRes add(ApplicantReq request);
    ApplicantRes update(Long id,ApplicantReq request) throws Exception;
    ApplicantRes getById(Long id);
    List<ApplicantRes> getList();
    void delete(Long id);
}
