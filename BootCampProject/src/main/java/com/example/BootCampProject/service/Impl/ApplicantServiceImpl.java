package com.example.BootCampProject.service.Impl;

import com.example.BootCampProject.dto.req.ApplicantReq;
import com.example.BootCampProject.dto.res.ApplicantRes;
import com.example.BootCampProject.entity.Applicant;
import com.example.BootCampProject.repository.ApplicantRepository;
import com.example.BootCampProject.service.ApplicantService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.BootCampProject.mapper.ApplicantMapper.mapToApplicant;
import static com.example.BootCampProject.mapper.ApplicantMapper.mapToResponse;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    private final ApplicantRepository applicantRepository;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }


    @Override
    public ApplicantRes add(ApplicantReq request) {
        Applicant applicant=mapToApplicant(request);
        Applicant newApplicant=applicantRepository.save(applicant);
        return mapToResponse(newApplicant);
    }

    @Override
    public ApplicantRes update(Long id,ApplicantReq request)  {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("applicant not found"));

        Applicant updated = mapToApplicant(request);
        updated.setId(applicant.getId());
        Applicant saved = applicantRepository.save(updated);
        return mapToResponse(saved);
    }

    @Override
    public ApplicantRes getById(Long id) {
       Applicant applicant=applicantRepository.findById(id).
               orElseThrow(()->new EntityNotFoundException("applicant not found"));
       return mapToResponse(applicant);
    }

    @Override
    public List<ApplicantRes> getList() {
        List<Applicant> applicantList=applicantRepository.findAll();
        List<ApplicantRes> responseList=new ArrayList<>();
        for(Applicant applicant:applicantList){
            responseList.add(mapToResponse(applicant));
        }
        return responseList;
    }

    @Override
    public void delete(Long id) {
        applicantRepository.deleteById(id);

    }

    @Override
    public Applicant findById(Long id) {
        return applicantRepository.findApplicantById(id).
                orElseThrow(()->new EntityNotFoundException("applicant not found"));
    }

}
