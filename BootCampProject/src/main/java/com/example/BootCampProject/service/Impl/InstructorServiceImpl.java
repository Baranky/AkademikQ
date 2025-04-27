package com.example.BootCampProject.service.Impl;

import com.example.BootCampProject.dto.req.InstructorReq;
import com.example.BootCampProject.dto.res.InstructorRes;
import com.example.BootCampProject.entity.Instructor;
import com.example.BootCampProject.repository.InstructorRepository;
import com.example.BootCampProject.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public InstructorRes add(InstructorReq request) {
        Instructor instructor = mapToInstructor(request);
        Instructor newInstructor = instructorRepository.save(instructor);
        return mapToResponse(newInstructor);
    }

    @Override
    public InstructorRes update(Long id,InstructorReq request) {
        Instructor existingInstructor= null;
        try {
            existingInstructor = instructorRepository.findById(id).orElseThrow(() ->
                    new Exception("Instructor not found with id: " + id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Instructor updatedInstructor = mapToInstructor(request);
        updatedInstructor.setId(existingInstructor.getId()); // Mevcut ID'yi koruyoruz
        Instructor savedInstructor = instructorRepository.save(updatedInstructor);
        return mapToResponse(savedInstructor);
    }

    @Override
    public InstructorRes getById(Long id) {
        Instructor instructor=instructorRepository.getReferenceById(id);
        return mapToResponse(instructor);
    }

    @Override
    public List<InstructorRes> getList() {
        List<Instructor> instructorList=instructorRepository.findAll();
        List<InstructorRes> responseList=new ArrayList<>();
        for(Instructor instructor:instructorList){
            responseList.add(mapToResponse(instructor));
        }
        return responseList;
    }

    @Override
    public void delete(Long id) {
        instructorRepository.deleteById(id);

    }

    private InstructorRes mapToResponse(Instructor instructor){
        InstructorRes response=new InstructorRes(
                instructor.getId(),
                instructor.getUsername(),
                instructor.getFirstName(),
                instructor.getLastName(),
                instructor.getDateOfBirth(),
                instructor.getNationalIdentity(),
                instructor.getEmail(),
                instructor.getPassword(),
                instructor.getCompanyName()
        );
        return response;
    }
    private Instructor mapToInstructor(InstructorReq request){
        Instructor instructor=new Instructor();
        instructor.setUsername(request.username());
        instructor.setFirstName(request.firstName());
        instructor.setLastName(request.lastName());
        instructor.setDateOfBirth(request.dateOfBirth());
        instructor.setNationalIdentity(request.nationalIdentity());
        instructor.setEmail(request.email());
        instructor.setPassword(request.password());
        instructor.setCompanyName(request.companyName());
        return instructor;
    }
}
