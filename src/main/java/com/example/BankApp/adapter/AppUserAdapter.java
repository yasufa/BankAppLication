package com.example.BankApp.adapter;

import com.example.BankApp.account.entity.Account;
import com.example.BankApp.user.command.AppUserUpdateCommand;
import com.example.BankApp.user.entity.AppUser;
import com.example.BankApp.user.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppUserAdapter {

    private AppUserService appUserService;

    @Autowired
    public AppUserAdapter(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    public List<AppUser> getAllAppUser() {
        return appUserService.getAllAppUser();
    }

    public AppUser createAppUser(AppUser appUser) {
        return appUserService.createUser(appUser);
    }

    public AppUser updateAppUser(Long id, AppUserUpdateCommand command) {
        return appUserService.updateUser(id, command);
    }
    public List<Account> getAllAccountByUserId(Long id){
        return appUserService.getAllAccountByUserId(id);
    }
}
