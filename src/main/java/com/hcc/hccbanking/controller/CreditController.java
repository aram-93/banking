package com.hcc.hccbanking.controller;

import com.hcc.hccbanking.payload.BankDTO;
import com.hcc.hccbanking.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class CreditController {
    @Autowired
    private DataService dataService;

    @PostMapping(value = "/edit")
    @PreAuthorize("hasRole('role_user')")
    public void updateCredit(Model model, @RequestBody BankDTO bankDTO) {

        dataService.updateBank(bankDTO);

        model.addAttribute("bankDTOGetName", bankDTO.getName());
    }

    @DeleteMapping(value = "/delete")
    @PreAuthorize("hasRole('role_user')")
    private ResponseEntity<String> deleteCredit(Model model, @RequestBody BankDTO bankDTO) {
        boolean success = dataService.deleteBankInfo(bankDTO);
        model.addAttribute("bankDTOGetName", bankDTO.getId());
        if (success) {
            return new ResponseEntity<>(
                    "success",
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    "failure",
                    HttpStatus.BAD_REQUEST);
        }
    }
}
