package com.example.BootCampProject.repository;

import com.example.BootCampProject.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  InstructorRepository extends JpaRepository<Instructor,Long> {
    Optional<Instructor> findInstructorById(Long id);

}
