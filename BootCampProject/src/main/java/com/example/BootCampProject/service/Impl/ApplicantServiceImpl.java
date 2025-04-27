package com.example.BootCampProject.service.Impl;

import com.example.BootCampProject.dto.req.ApplicantReq;
import com.example.BootCampProject.dto.res.ApplicantRes;
import com.example.BootCampProject.entity.Applicant;
import com.example.BootCampProject.repository.ApplicantRepository;
import com.example.BootCampProject.service.ApplicantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    private final ApplicantRepository applicantRepository;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public ApplicantRes add(ApplicantReq request) {
        Applicant applicant=mapToApplication(request);
        Applicant newApplicant=applicantRepository.save(applicant);
        return mapToResponse(newApplicant);
    }

    @Override
    public ApplicantRes update(Long id,ApplicantReq request)  {
        Applicant existingApplicant = null;
        try {
            existingApplicant = applicantRepository.findById(id).orElseThrow(() ->
                    new Exception("Applicant not found with id: " + id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Applicant updatedApplicant = mapToApplication(request);
        updatedApplicant.setId(existingApplicant.getId()); // Mevcut ID'yi koruyoruz
        Applicant savedApplicant = applicantRepository.save(updatedApplicant);
        return mapToResponse(savedApplicant);
    }

    @Override
    public ApplicantRes getById(Long id) {
       Applicant applicant=applicantRepository.getReferenceById(id);
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
    private ApplicantRes mapToResponse(Applicant applicant){
        ApplicantRes response=new ApplicantRes(
                applicant.getId(),
                applicant.getUsername(),
                applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getDateOfBirth(),
                applicant.getNationalIdentity(),
                applicant.getEmail(),
                applicant.getPassword(),
                applicant.getAbout()
        );
        return response;
    }
    private Applicant mapToApplication(ApplicantReq request){
        Applicant applicant=new Applicant();
        applicant.setUsername(request.username());
        applicant.setFirstName(request.firstName());
        applicant.setLastName(request.lastName());
        applicant.setDateOfBirth(request.dateOfBirth());
        applicant.setNationalIdentity(request.nationalIdentity());
        applicant.setEmail(request.email());
        applicant.setPassword(request.password());
        applicant.setAbout(request.about());
        return applicant;
    }
}
