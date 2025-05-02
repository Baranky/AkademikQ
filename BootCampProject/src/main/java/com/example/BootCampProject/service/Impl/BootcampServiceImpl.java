package com.example.BootCampProject.service.Impl;

import com.example.BootCampProject.dto.req.BootcampReq;
import com.example.BootCampProject.dto.res.BootcampRes;
import com.example.BootCampProject.entity.Bootcamp;
import com.example.BootCampProject.entity.Instructor;
import com.example.BootCampProject.enums.BootcampState;
import com.example.BootCampProject.mapper.BootcampMapper;
import com.example.BootCampProject.repository.BootcampRepository;
import com.example.BootCampProject.service.BootcampService;
import com.example.BootCampProject.service.InstructorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.BootCampProject.mapper.BootcampMapper.mapToBootcamp;
import static com.example.BootCampProject.mapper.BootcampMapper.mapToResponse;

@Service
public class BootcampServiceImpl implements BootcampService {
    private final BootcampRepository bootcampRepository;
    private final InstructorService instructorService;

    public BootcampServiceImpl(BootcampRepository bootcampRepository, InstructorService instructorService) {
        this.bootcampRepository = bootcampRepository;
        this.instructorService = instructorService;
    }

    @Override
    public BootcampRes add(BootcampReq request) {
        Instructor instructor=instructorService.findById(request.instructorId());
        Bootcamp bootcamp=mapToBootcamp(request,instructor);
        Bootcamp savedBootcamp=bootcampRepository.save(bootcamp);
        return mapToResponse(savedBootcamp);
    }

    @Override
    public BootcampRes update(Long id, BootcampReq request){
        Bootcamp bootcamp = bootcampRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("bootcamp not found"));

        Instructor instructor=instructorService.findById(request.instructorId());

        Bootcamp updated = mapToBootcamp(request,instructor);
        updated.setId(bootcamp.getId());
        Bootcamp saved = bootcampRepository.save(updated);
        return mapToResponse(saved);
    }

    @Override
    public BootcampRes getById(Long id) {
        Bootcamp bootcamp=bootcampRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("bootcamp not found with id: " + id));
        return mapToResponse(bootcamp);
    }

    @Override
    public List<BootcampRes> getList() {
        List<Bootcamp> application =bootcampRepository.findAll();
        return application.stream().map(BootcampMapper::mapToResponse).collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {
        bootcampRepository.deleteById(id);

    }

    @Override
    public Bootcamp findById(Long id)
    {
        return bootcampRepository.getReferenceById(id);
    }

    @Override
    public List<BootcampRes> findByBootcampState() {
        return bootcampRepository.findByBootcampState(BootcampState.PREPARING);
    }
}
