package com.example.BootCampProject.service.Impl;

import com.example.BootCampProject.dto.req.BlacklistReq;
import com.example.BootCampProject.dto.res.BlacklistRes;
import com.example.BootCampProject.entity.Applicant;
import com.example.BootCampProject.entity.Blacklist;
import com.example.BootCampProject.mapper.BlackListMapper;
import com.example.BootCampProject.repository.BlacklistRepository;
import com.example.BootCampProject.service.ApplicantService;
import com.example.BootCampProject.service.BlacklistService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.BootCampProject.mapper.BlackListMapper.mapToBlackList;
import static com.example.BootCampProject.mapper.BlackListMapper.mapToResponse;

@Service
public class BlacklistServiceImpl implements BlacklistService {
    private  final BlacklistRepository blacklistRepository;
    private final ApplicantService applicantService;

    public BlacklistServiceImpl(BlacklistRepository blacklistRepository, ApplicantService applicantService) {
        this.blacklistRepository = blacklistRepository;
        this.applicantService = applicantService;
    }

    @Override
    public BlacklistRes add(BlacklistReq request) {
        Applicant applicant=applicantService.findById(request.applicantId());
        Blacklist blacklist=mapToBlackList(request,applicant);
        Blacklist savedBlackList=blacklistRepository.save(blacklist);
        return mapToResponse(savedBlackList);
    }

    @Override
    public BlacklistRes update(Long id, BlacklistReq request) {
        Blacklist blacklist = blacklistRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("blackList not found"));

        Applicant applicant=applicantService.findById(request.applicantId());
        Blacklist updated = mapToBlackList(request,applicant);
        updated.setId(blacklist.getId());
        Blacklist saved = blacklistRepository.save(updated);
        return mapToResponse(saved);
    }

    @Override
    public BlacklistRes getById(Long id) {
        Blacklist blacklist=blacklistRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("blacklist not found with id: " + id));
        return mapToResponse(blacklist);
    }

    @Override
    public List<BlacklistRes> getList() {
        List<Blacklist> blacklists =blacklistRepository.findAll();
        return blacklists.stream().map(BlackListMapper::mapToResponse).collect(Collectors.toList());

}

    @Override
    public void delete(Long id) {
        blacklistRepository.deleteById(id);
    }

    @Override
    public boolean  existsByApplicantId(Long applicantId) {
        return blacklistRepository.existsByApplicantId(applicantId);
    }
}
