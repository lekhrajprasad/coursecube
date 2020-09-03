package com.coursecube.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
    
    @PostMapping("/addAccount")
    public String addAccount(@RequestBody Account acc){
        System.out.println("AccountController - addAccount()");
        accountService.addAccount(acc);
        return "Account Added Successfully";
    }
}
