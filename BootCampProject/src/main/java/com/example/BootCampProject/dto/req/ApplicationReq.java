package com.example.BootCampProject.dto.req;

import com.example.BootCampProject.enums.ApplicationState;

public record ApplicationReq(
        ApplicationState applicationState,
        Long bootcampId,
        Long applicantId
) {
}
