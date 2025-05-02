package com.example.BootCampProject.repository;

import com.example.BootCampProject.dto.res.ApplicationRes;
import com.example.BootCampProject.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {
    List<ApplicationRes> findByApplicantId(Long applicant_id);

}
