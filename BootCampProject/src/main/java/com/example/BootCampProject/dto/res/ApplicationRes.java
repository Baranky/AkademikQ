package com.example.BootCampProject.dto.res;

import com.example.BootCampProject.enums.ApplicationState;

public record ApplicationRes(

        Long id,
        ApplicationState applicationState,
        Long bootcampId,
        Long applicantId
) {
}
