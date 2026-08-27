package com.project.missingperson.controller;

import com.project.missingperson.service.MatchService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match")
@CrossOrigin("*")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/{missingId}/{foundId}")
    public String matchPersons(
            @PathVariable Long missingId,
            @PathVariable Long foundId) {

        return matchService.matchPersons(missingId, foundId);
    }
}