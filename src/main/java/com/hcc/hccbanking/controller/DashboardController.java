package com.hcc.hccbanking.controller;

import com.hcc.hccbanking.model.CreditPageViewGrouped;
import com.hcc.hccbanking.model.CreditPageViewItem;
import com.hcc.hccbanking.service.DataService;
import com.hcc.hccbanking.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"/dashboard"})
public class DashboardController {

    @Autowired
    private DataService dataService;

    @Autowired
    private ValidationService validationService;

    @GetMapping
    public String main(Model model) {
        return "home";
    }

    @GetMapping("/{bankName}")
    public String main(Model model, @PathVariable String bankName) {
        CreditPageViewGrouped creditPageViewGrouped;
        if (validationService.isBankNameValid(bankName)) {
            creditPageViewGrouped = dataService.getCreditPageViewGrouped(bankName);
        } else {
            return "notfound";
        }
        model.addAttribute("currentBankInfo", creditPageViewGrouped);
        return "bank";
    }

    @GetMapping("/{clientType}/{creditType}")
    public String main(Model model, @PathVariable String clientType, @PathVariable String creditType) {

        List<CreditPageViewItem> creditPageViewItemList;
        if (validationService.isClientTypeValid(clientType) && validationService.isCreditTypeValid(creditType)) {
            creditPageViewItemList = dataService.getCreditPageViewItemList(clientType, creditType);
        } else {
            return "notfound";
        }
        model.addAttribute("creditsViewItemList", creditPageViewItemList);

        return "credit";
    }

//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
}