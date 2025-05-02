package com.example.BootCampProject.dto.res;

import java.time.LocalDateTime;

public record BlacklistRes(
        Long id,
        String reason,
        LocalDateTime date,
        Long applicantId
) {
}
