package com.example.BootCampProject.controller;

import com.example.BootCampProject.dto.req.ApplicationReq;
import com.example.BootCampProject.dto.res.ApplicationRes;
import com.example.BootCampProject.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/{id}")
    public ApplicationRes getById(@PathVariable Long id) {
        return applicationService.getById(id);
    }

    @GetMapping()
    public List<ApplicationRes> getAllApplication() {
        return applicationService.getList();
    }

    @PostMapping()
    public ApplicationRes saveApplication(@RequestBody ApplicationReq request) {
        return applicationService.add(request);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        applicationService.delete(id);
    }

    @PutMapping("/{id}")
    public ApplicationRes updateApplication(@PathVariable Long id, @RequestBody ApplicationReq request) {
        return applicationService.update(id, request);

    }

    @GetMapping("/applicantId/{id}")
    public List<ApplicationRes> findByApplicantId(@PathVariable Long id) {
        return applicationService.findByApplicantId(id);
    }
}

