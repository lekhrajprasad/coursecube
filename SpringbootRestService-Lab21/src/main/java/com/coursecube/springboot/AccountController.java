package com.coursecube.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
    
    @PostMapping("/account/add")
    public String addAccount(@RequestBody Account acc){
        System.out.println("AccountController - addAccount()");
        accountService.addAccount(acc);
        return "Account Added Successfully";
    }
    @GetMapping("/account/get/{accno}")
    public Account getAccount(@PathVariable int accno){
        System.out.println("AccountController - getAccount(..)");
        Account account = accountService.getAccountByAccno(accno);
        System.out.println(account);
        return account;
    }

    @PutMapping("/account/deposit")
    public void deposit(@RequestBody TxInfo txInfo){
        accountService.deposit(txInfo);
    }

    @PutMapping("/account/withdraw")
    public void withdraw(@RequestBody TxInfo txInfo){
        accountService.withdraw(txInfo);
    }

    @DeleteMapping("/account/delete/{accno}")
    public void deleteAccount(@PathVariable int accno){
        accountService.deleteAccount(accno);
    }

    @GetMapping("/account/get/all")
    public List<Account> getAllAccount(){
        System.out.println("AccountController - getAccount(..)");
        return accountService.getAllAccounts();
    }

    @GetMapping(name = "/account/getpdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody ResponseEntity<byte[]> getPdf() throws IOException{
        ClassPathResource pdfFile = new ClassPathResource("atalhos_eclipse.pdf");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        System.out.println("pppppppppppdddddddddddddddddddffffffffffffffffffff");
        return ResponseEntity.ok().headers(headers).contentLength(pdfFile.contentLength())
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_OCTET_STREAM_VALUE))
                .body(pdfFile.getInputStream().readAllBytes());
    }
}
