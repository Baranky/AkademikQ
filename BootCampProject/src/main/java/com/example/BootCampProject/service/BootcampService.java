package com.example.BootCampProject.service;

import com.example.BootCampProject.dto.req.BootcampReq;
import com.example.BootCampProject.dto.res.BootcampRes;
import com.example.BootCampProject.entity.Bootcamp;

import java.util.List;
import java.util.Optional;

public interface BootcampService {
    BootcampRes add(BootcampReq request);
    BootcampRes update(Long id,BootcampReq request);
    BootcampRes getById(Long id);
    List<BootcampRes> getList();
    void delete(Long id);
    Bootcamp findById(Long id);
    List<BootcampRes> findByBootcampState();

}
