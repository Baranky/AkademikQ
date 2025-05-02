package com.example.BootCampProject.service;



import com.example.BootCampProject.dto.req.ApplicationReq;
import com.example.BootCampProject.dto.res.ApplicationRes;
import com.example.BootCampProject.entity.Application;

import java.util.List;

public interface ApplicationService {
    ApplicationRes add(ApplicationReq request);
    ApplicationRes update(Long id,ApplicationReq request) ;
    ApplicationRes getById(Long id);
    List<ApplicationRes> getList();
    void delete(Long id);
    List<ApplicationRes> findByApplicantId(Long applicant_id);

}
