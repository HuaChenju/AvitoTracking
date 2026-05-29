package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.service.GoogleSheetsService;

@RestController
public class TestController {

    private final GoogleSheetsService googleSheetsService;

    public TestController(GoogleSheetsService googleSheetsService) {
        this.googleSheetsService = googleSheetsService;
    }

    @GetMapping("/parseUpdates")
    public String test() throws Exception {
        boolean res = googleSheetsService.readSpreadsheetId();
        if (res) {
            return "done parse updates";
        } else {
            return "failed parse updates";
        }
    }
}