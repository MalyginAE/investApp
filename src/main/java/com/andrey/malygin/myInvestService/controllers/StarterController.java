package com.andrey.malygin.myInvestService.controllers;

import com.andrey.malygin.myInvestService.postgresql.telegram.entities.User;
import com.andrey.malygin.myInvestService.postgresql.telegram.repository.UserRepository;
import com.andrey.malygin.myInvestService.tinkoffApi.InvestApiGettingPersonalDataFromMarketUtil;
import lombok.RequiredArgsConstructor;
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
