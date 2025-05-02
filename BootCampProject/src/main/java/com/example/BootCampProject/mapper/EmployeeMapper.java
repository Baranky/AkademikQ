package com.example.BootCampProject.mapper;

import com.example.BootCampProject.dto.req.EmployeeReq;
import com.example.BootCampProject.dto.res.EmployeeRes;
import com.example.BootCampProject.entity.Employee;

public class EmployeeMapper {
    public static EmployeeRes mapToResponse(Employee employee){
        EmployeeRes response=new EmployeeRes(
                employee.getId(),
                employee.getUsername(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDateOfBirth(),
                employee.getNationalIdentity(),
                employee.getEmail(),
                employee.getPassword(),
                employee.getPosition()
        );
        return response;
    }
    public static Employee mapToEmployee (EmployeeReq request){
        Employee employee=new Employee();
        employee.setUsername(request.username());
        employee.setFirstName(request.firstName());
        employee.setLastName(request.lastName());
        employee.setDateOfBirth(request.dateOfBirth());
        employee.setNationalIdentity(request.nationalIdentity());
        employee.setEmail(request.email());
        employee.setPassword(request.password());
        employee.setPosition(request.position());
        return employee;
    }
}
