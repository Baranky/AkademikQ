package com.example.BootCampProject.controller;

import com.example.BootCampProject.dto.req.BootcampReq;
import com.example.BootCampProject.dto.res.BlacklistRes;
import com.example.BootCampProject.dto.res.BootcampRes;
import com.example.BootCampProject.service.BootcampService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bootcamp")
public class BootcampController {
   private final BootcampService bootcampService;

    public BootcampController(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }
    @GetMapping()
    public List<BootcampRes> getAllBootcamp(){
        return bootcampService.getList();
    }
    @GetMapping("/{id}")
    public BootcampRes getById(@PathVariable Long id){
        return bootcampService.getById(id);
    }
    @PostMapping
    public BootcampRes createBootcamp(@RequestBody BootcampReq request){
        return bootcampService.add(request);
    }
    @PutMapping("/{id}")
    public BootcampRes updateBootcamp(@PathVariable Long id,@RequestBody BootcampReq request ){

        return bootcampService.update(id,request);
    }
    @DeleteMapping("/{id}")
    public void deleteBootcamp(@PathVariable Long id){
        bootcampService.delete(id);
    }

    @GetMapping("/BootcampState")
    public List<BootcampRes> findByBootcampState(){
        return bootcampService.findByBootcampState();
    }
}
