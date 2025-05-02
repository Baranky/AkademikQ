package com.example.BootCampProject.repository;

import com.example.BootCampProject.entity.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist,Long> {
    boolean  existsByApplicantId(Long applicant_id);//basvuru yapan kara listede mi konrtolu
}
