package com.example.BootCampProject.repository;

import com.example.BootCampProject.dto.res.BootcampRes;
import com.example.BootCampProject.entity.Bootcamp;
import com.example.BootCampProject.enums.BootcampState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BootcampRepository extends JpaRepository<Bootcamp ,Long> {
    List<BootcampRes> findByBootcampState(BootcampState bootcampState);
}
