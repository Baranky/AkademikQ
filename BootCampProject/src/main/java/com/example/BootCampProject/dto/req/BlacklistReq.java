package com.example.BootCampProject.dto.req;

import java.time.LocalDateTime;

public record BlacklistReq(
        String reason,
        LocalDateTime date,
        Long applicantId
) {
}
