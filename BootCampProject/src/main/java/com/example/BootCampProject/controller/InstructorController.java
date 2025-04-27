package com.example.BootCampProject.controller;


import com.example.BootCampProject.dto.req.InstructorReq;
import com.example.BootCampProject.dto.res.InstructorRes;
import com.example.BootCampProject.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @GetMapping()
    public List<InstructorRes> ListInstructor(){
        return  instructorService.getList();
    }
    @PostMapping()
    public  InstructorRes addInstructor(@RequestBody InstructorReq request){
        return instructorService.add(request);
    }
    @GetMapping("/{id}")
    public InstructorRes getByIdApplicant(@PathVariable Long id){
        return instructorService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteApplicant(@PathVariable Long id){
        instructorService.delete(id);
    }
    @PutMapping("/{id}")
    public InstructorRes updateApplicant(@RequestBody InstructorReq request,@PathVariable Long id){
        try {
            return instructorService.update(id,request);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
