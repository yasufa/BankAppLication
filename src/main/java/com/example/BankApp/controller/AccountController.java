package com.example.BankApp.controller;

import com.example.BankApp.account.entity.Account;
import com.example.BankApp.account.model.AccountTransferCommand;
import com.example.BankApp.account.service.AccountService;
import com.example.BankApp.adapter.AccountAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
    private AccountAdapter accountAdapter;

    @Autowired
    public AccountController(AccountAdapter accountAdapter){
        this.accountAdapter = accountAdapter;
    }


    @PostMapping
    public Long create(@RequestBody Account account){
        return this.accountAdapter.createAccount(account);
    }

//    @GetMapping("{userId}")
//    public List<Account> getAllByUserId(Long userId){
//        return this.accountAdapter.getAllAccountByUserId(userId);
//    }

    @DeleteMapping
    public void deleteAccount(Long id){
         this.accountAdapter.deleteAccount(id);
    }

    @PutMapping
    public void transfer(@RequestBody AccountTransferCommand command) throws Exception {
        this.accountAdapter.transfer(command);
    }
}
