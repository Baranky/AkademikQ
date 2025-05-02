package com.example.BootCampProject.mapper;

import com.example.BootCampProject.dto.req.BlacklistReq;
import com.example.BootCampProject.dto.res.BlacklistRes;
import com.example.BootCampProject.entity.Applicant;
import com.example.BootCampProject.entity.Blacklist;

public class BlackListMapper {
    public static BlacklistRes mapToResponse(Blacklist blacklist){
        return new BlacklistRes(
                blacklist.getId(),
                blacklist.getReason(),
                blacklist.getDate(),
                blacklist.getApplicant().getId()
        );
    }
    public static Blacklist mapToBlackList(BlacklistReq request, Applicant applicant){
        Blacklist blacklist=new Blacklist();
        blacklist.setDate(request.date());
        blacklist.setReason(request.reason());
        blacklist.setApplicant(applicant);
        return blacklist;
    }
}
