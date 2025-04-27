package com.example.BootCampProject.service;

import com.example.BootCampProject.dto.req.EmployeeReq;
import com.example.BootCampProject.dto.res.EmployeeRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    EmployeeRes add(EmployeeReq request);
    EmployeeRes update(Long id,EmployeeReq request);
    EmployeeRes getById(Long id);
    List<EmployeeRes> getList();
    void delete(Long id);
}
