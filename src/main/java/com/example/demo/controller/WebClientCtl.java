package com.example.demo.controller;

import com.example.demo.ResponseData;
import com.example.demo.domain.AccountData;
import com.example.demo.service.WebClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/webclient")
public class WebClientCtl {

    private final WebClientService webClientService;

    public WebClientCtl(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    @GetMapping("/getAccount")
    public ResponseData<AccountData> getAccount(@RequestParam int id,
                                                @RequestParam String username) {
        return webClientService.filterAccount();
    }
}
