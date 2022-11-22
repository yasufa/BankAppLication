package com.example.BankApp.controller;

import com.example.BankApp.account.entity.Account;
import com.example.BankApp.adapter.AppUserAdapter;
import com.example.BankApp.user.command.AppUserUpdateCommand;
import com.example.BankApp.user.entity.AppUser;
import com.example.BankApp.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class AppUserController {
    private AppUserAdapter appUserAdapter;

    @Autowired
    public AppUserController(AppUserAdapter appUserAdapter){
        super();
        this.appUserAdapter = appUserAdapter;
    }

    @PostMapping
    public AppUser create(@RequestBody AppUser appUser){
        return this.appUserAdapter.createAppUser(appUser);
    }

    @GetMapping
    public List<AppUser> getAllAppUser(){
        return this.appUserAdapter.getAllAppUser();
    }

    @PutMapping
    public AppUser updateUser(Long id, @RequestBody AppUserUpdateCommand command){
        return this.appUserAdapter.updateAppUser(id,command);
    }

    @GetMapping("{userId}")
    public List<Account> getAllByUserId(Long userId){
        return this.appUserAdapter.getAllAccountByUserId(userId);
    }

}
