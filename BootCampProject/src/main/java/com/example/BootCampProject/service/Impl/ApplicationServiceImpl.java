package com.example.BootCampProject.service.Impl;

import com.example.BootCampProject.dto.req.ApplicationReq;
import com.example.BootCampProject.dto.res.ApplicationRes;
import com.example.BootCampProject.entity.Applicant;
import com.example.BootCampProject.entity.Application;
import com.example.BootCampProject.entity.Bootcamp;
import com.example.BootCampProject.mapper.ApplicationMapper;
import com.example.BootCampProject.repository.ApplicationRepository;
import com.example.BootCampProject.service.ApplicantService;
import com.example.BootCampProject.service.ApplicationService;
import com.example.BootCampProject.service.BlacklistService;
import com.example.BootCampProject.service.BootcampService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.BootCampProject.mapper.ApplicationMapper.mapToApplication;
import static com.example.BootCampProject.mapper.ApplicationMapper.mapToResponse;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final BootcampService bootcampService;
    private final ApplicantService applicantService;
    private  final BlacklistService blacklistService;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, BootcampService bootcampService, ApplicantService applicantService, BlacklistService blacklistService) {
        this.applicationRepository = applicationRepository;
        this.bootcampService = bootcampService;
        this.applicantService = applicantService;
        this.blacklistService = blacklistService;
    }

    @Override
    public ApplicationRes add(ApplicationReq request) {
        if (blacklistService.existsByApplicantId(request.applicantId())) {
            throw new RuntimeException("Bu kullanıcı kara listede, başvuru yapamaz.");
        }
        Bootcamp bootcamp=bootcampService.findById(request.applicantId());
        Applicant applicant=applicantService.findById(request.bootcampId());
        Application application=mapToApplication(request,applicant,bootcamp);
        Application savedApplicant=applicationRepository.save(application);
        return mapToResponse(savedApplicant);
    }

    @Override
    public ApplicationRes update(Long id, ApplicationReq request) {
        Application application =applicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("application not found"));

        Applicant applicant=applicantService.findById(request.applicantId());
        Bootcamp bootcamp=bootcampService.findById(request.bootcampId());

        Application updated = mapToApplication(request,applicant,bootcamp);
        updated.setId(application.getId());
        Application saved = applicationRepository.save(updated);
        return mapToResponse(saved);
    }

    @Override
    public ApplicationRes getById(Long id) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Application not found with id: " + id));
        return ApplicationMapper.mapToResponse(application);
    }

    @Override
    public List<ApplicationRes> getList() {
       List<Application> application =applicationRepository.findAll();
        return application.stream().map(ApplicationMapper::mapToResponse).collect(Collectors.toList());    }

    @Override
    public void delete(Long id) {
        applicationRepository.deleteById(id);

    }

    @Override
    public List<ApplicationRes> findByApplicantId(Long applicant_id) {
        return applicationRepository.findByApplicantId(applicant_id);
    }
}
