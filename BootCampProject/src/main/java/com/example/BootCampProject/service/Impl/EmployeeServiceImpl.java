package com.example.BootCampProject.service.Impl;

import com.example.BootCampProject.dto.req.EmployeeReq;
import com.example.BootCampProject.dto.res.EmployeeRes;
import com.example.BootCampProject.entity.Employee;
import com.example.BootCampProject.repository.EmployeeRepository;
import com.example.BootCampProject.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Employee existingEmployee = null;
        try {
            existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
                    new Exception("Employee not found with id: " + id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Employee updatedEmployee = mapToEmployee(request);
        updatedEmployee.setId(existingEmployee.getId()); // Mevcut ID'yi koruyoruz
        Employee savedEmployee = employeeRepository.save(updatedEmployee);
        return mapToResponse(savedEmployee);
    }

    @Override
    public EmployeeRes getById(Long id) {
        Employee employee=employeeRepository.getReferenceById(id);
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

    private EmployeeRes mapToResponse(Employee employee){
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
    private Employee mapToEmployee (EmployeeReq request){
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
