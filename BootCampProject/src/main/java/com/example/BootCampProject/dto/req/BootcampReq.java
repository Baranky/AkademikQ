package com.example.BootCampProject.dto.req;

import com.example.BootCampProject.enums.BootcampState;

import java.time.LocalDateTime;

public record BootcampReq(
        String name,
        LocalDateTime startDate,
        LocalDateTime endDate,
        BootcampState bootcampState,
        Long instructorId
) {
}
