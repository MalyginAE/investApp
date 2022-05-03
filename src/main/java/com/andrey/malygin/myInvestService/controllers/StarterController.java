package com.andrey.malygin.myInvestService.controllers;

import com.andrey.malygin.myInvestService.tinkoffApi.InvestApiGettingPersonalDataFromMarketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/")

public class StarterController {
    @Autowired
    InvestApiGettingPersonalDataFromMarketUtil investApiGettingPersonalDataFromMarketUtil;
    @GetMapping
    @ResponseBody
    public ResponseEntity response(){
        return ResponseEntity.ok(investApiGettingPersonalDataFromMarketUtil.getListMoney());
    }
}
