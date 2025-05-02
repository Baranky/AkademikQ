package com.example.BootCampProject.repository;

import com.example.BootCampProject.entity.Applicant;
import com.example.BootCampProject.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
    Optional<Applicant> findApplicantById(Long id);

}
