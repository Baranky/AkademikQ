package com.example.BootCampProject.dto.req;

import java.util.Date;

public record ApplicantReq(
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
