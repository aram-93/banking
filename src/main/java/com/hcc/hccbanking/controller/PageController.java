package com.hcc.hccbanking.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PageController {
    @GetMapping({"/","index"})
    @PreAuthorize("hasRole('role_user')")
    public String main(Model model){
        return "index";
    }
}
