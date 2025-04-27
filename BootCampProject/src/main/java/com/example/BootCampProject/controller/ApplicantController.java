package com.example.BootCampProject.controller;

import com.example.BootCampProject.dto.req.ApplicantReq;
import com.example.BootCampProject.dto.res.ApplicantRes;
import com.example.BootCampProject.service.ApplicantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }
    @GetMapping()
    public List<ApplicantRes> ListApplicant(){
        return  applicantService.getList();
    }
    @PostMapping()
    public  ApplicantRes addApplicant(@RequestBody ApplicantReq request){
        return applicantService.add(request);
    }
    @GetMapping("/{id}")
    public ApplicantRes getByIdApplicant(@PathVariable Long id){
        return applicantService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteApplicant(@PathVariable Long id){
        applicantService.delete(id);
    }
    @PutMapping("/{id}")
    public ApplicantRes updateApplicant(@RequestBody ApplicantReq request,@PathVariable Long id){
        try {
            return applicantService.update(id,request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
