package com.example.BootCampProject.dto.res;

import com.example.BootCampProject.enums.BootcampState;

import java.time.LocalDateTime;

public record BootcampRes(
        Long id,
        String name,
        LocalDateTime startDate,
        LocalDateTime endDate,
        BootcampState bootcampState,
        Long instructorId
) {
}
