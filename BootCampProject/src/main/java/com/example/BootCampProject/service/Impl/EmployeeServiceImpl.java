package com.example.BootCampProject.service.Impl;

import com.example.BootCampProject.dto.req.EmployeeReq;
import com.example.BootCampProject.dto.res.EmployeeRes;
import com.example.BootCampProject.entity.Employee;
import com.example.BootCampProject.repository.EmployeeRepository;
import com.example.BootCampProject.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.BootCampProject.mapper.EmployeeMapper.mapToEmployee;
import static com.example.BootCampProject.mapper.EmployeeMapper.mapToResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public EmployeeRes add(EmployeeReq request) {
        Employee employee=mapToEmployee(request);
        Employee newEmployee=employeeRepository.save(employee);
        return mapToResponse(newEmployee);
    }

    @Override
    public EmployeeRes update(Long id,EmployeeReq request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        Employee updated = mapToEmployee(request);
        updated.setId(employee.getId());
        Employee saved = employeeRepository.save(updated);
        return mapToResponse(saved);
    }

    @Override
    public EmployeeRes getById(Long id) {
         Employee employee=employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("employee not found with id: " + id));
        return mapToResponse(employee);
    }

    @Override
    public List<EmployeeRes> getList() {
        List<Employee> employeeList=employeeRepository.findAll();
        List<EmployeeRes> responseList=new ArrayList<>();
        for(Employee employee:employeeList){
            responseList.add(mapToResponse(employee));
        }
        return responseList;
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id).
                orElseThrow(()-> new EntityNotFoundException("employee not found"));
    }


}
