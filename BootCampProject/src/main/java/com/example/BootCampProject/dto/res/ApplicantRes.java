package com.example.BootCampProject.dto.res;

import java.util.Date;

public record ApplicantRes(
        Long id,
        String username,
        String firstName,
        String lastName,
        Date dateOfBirth,
        String nationalIdentity,
        String email,
        String password,
        String  about
) {
}
