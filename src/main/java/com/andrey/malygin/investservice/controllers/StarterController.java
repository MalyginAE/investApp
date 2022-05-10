package com.andrey.malygin.investservice.controllers;

import com.andrey.malygin.investservice.postgresql.telegram.repository.UserRepository;
import com.andrey.malygin.investservice.tinkoffApi.InvestApiGettingPersonalDataFromMarketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/")
public class StarterController {
    @Autowired
    InvestApiGettingPersonalDataFromMarketUtil investApiGettingPersonalDataFromMarketUtil;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    @ResponseBody
    public ResponseEntity response() {
       // User admin = userRepository.save(new User( "Admin"));
       // System.out.println(admin.getId());
        return ResponseEntity.ok(investApiGettingPersonalDataFromMarketUtil.getListMoney());
    }
}
