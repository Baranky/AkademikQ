package com.example.BootCampProject.service.Impl;

import com.example.BootCampProject.dto.req.InstructorReq;
import com.example.BootCampProject.dto.res.InstructorRes;
import com.example.BootCampProject.entity.Instructor;
import com.example.BootCampProject.repository.InstructorRepository;
import com.example.BootCampProject.service.InstructorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.BootCampProject.mapper.InstructorMapper.mapToInstructor;
import static com.example.BootCampProject.mapper.InstructorMapper.mapToResponse;

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
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("instructor not found"));

        Instructor updated = mapToInstructor(request);
        updated.setId(instructor.getId());
        Instructor saved = instructorRepository.save(updated);
        return mapToResponse(saved);
    }

    @Override
    public InstructorRes getById(Long id) {
        Instructor instructor=instructorRepository.findById(id).
                orElseThrow(()-> new EntityNotFoundException("instructor not found"));
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

    @Override
    public Instructor findById(Long id) {
        return instructorRepository.findInstructorById(id).
                orElseThrow(()-> new EntityNotFoundException("instructor not found"));
    }


}
