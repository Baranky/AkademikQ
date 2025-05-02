package com.example.BootCampProject.controller;

import com.example.BootCampProject.dto.req.EmployeeReq;
import com.example.BootCampProject.dto.res.EmployeeRes;
import com.example.BootCampProject.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<EmployeeRes> ListEmployee(){
        return  employeeService.getList();
    }
    @PostMapping()
    public  EmployeeRes addEmployee(@RequestBody EmployeeReq request){
        return employeeService.add(request);
    }
    @GetMapping("/{id}")
    public EmployeeRes getByIdEmployee(@PathVariable Long id){
        return employeeService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.delete(id);
    }
    @PutMapping("/{id}")
    public EmployeeRes updateEmployee(@RequestBody EmployeeReq request,@PathVariable Long id){

            return employeeService.update(id,request);
    }
}
