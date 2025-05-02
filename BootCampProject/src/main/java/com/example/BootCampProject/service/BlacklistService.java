package com.example.BootCampProject.service;


import com.example.BootCampProject.dto.req.BlacklistReq;
import com.example.BootCampProject.dto.res.BlacklistRes;

import java.util.List;
import java.util.Optional;

public interface BlacklistService {
    BlacklistRes add(BlacklistReq request);
    BlacklistRes update(Long id,BlacklistReq request);
    BlacklistRes getById(Long id);
    List<BlacklistRes> getList();
    void delete(Long id);
    boolean  existsByApplicantId(Long applicantId);
}
