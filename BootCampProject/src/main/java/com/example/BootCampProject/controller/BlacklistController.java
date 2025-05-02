package com.example.BootCampProject.controller;

import com.example.BootCampProject.dto.req.BlacklistReq;
import com.example.BootCampProject.dto.res.BlacklistRes;
import com.example.BootCampProject.service.BlacklistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/BlackList")
public class BlacklistController {
    private final BlacklistService blacklistService;

    public BlacklistController(BlacklistService blacklistService) {
        this.blacklistService = blacklistService;
    }
    @GetMapping()
    public List<BlacklistRes> getAllBlackList(){
        return blacklistService.getList();
    }
    @GetMapping("/{id}")
    public BlacklistRes getById(@PathVariable Long id){
        return blacklistService.getById(id);
    }
    @PostMapping
    public BlacklistRes createBlackList(@RequestBody BlacklistReq request){
        return blacklistService.add(request);
    }
    @PutMapping("/{id}")
    public BlacklistRes updateBlackList(@PathVariable Long id, @RequestBody BlacklistReq request){
        return blacklistService.update(id,request);
    }
    @DeleteMapping ("/{id}")
    public void deleteBlackList(@PathVariable Long id){
        blacklistService.delete(id);
    }


}
