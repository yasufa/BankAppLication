package com.example.BankApp.user.service;

import com.example.BankApp.account.entity.Account;
import com.example.BankApp.account.model.AccountTransferCommand;
import com.example.BankApp.account.repository.AccountRepository;
import com.example.BankApp.account.service.AccountService;
import com.example.BankApp.user.command.AppUserUpdateCommand;
import com.example.BankApp.user.entity.AppUser;
import com.example.BankApp.user.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService{
    private AppUserRepository appUserRepository;

    private AccountService accountService;

    @Autowired
    public AppUserServiceImpl(AppUserRepository repository,AccountService accountService){
        this.accountService = accountService;
        this.appUserRepository = repository;
    }

    @Override
    public AppUser createUser(AppUser appUser) {
        appUserRepository.save(appUser);
        return appUser;
    }

    @Override
    public List<AppUser> getAllAppUser() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser updateUser(Long id, AppUserUpdateCommand command) {
        AppUser user = appUserRepository.findById(id).get();
        user.update(command);
        appUserRepository.save(user);
        return user;
    }

    @Override
    public List<Account> getAllAccountByUserId(Long id) {
        List<Account> allAccount = accountService.getAllAccount();
        List<Account> userIdList = new ArrayList<Account>();
        for (Account item : allAccount){
            if (item.getAppUser().getId() == id){
                userIdList.add(item);
            }
        }
        return userIdList;
    }


    @Override
    public AppUser getOneUserByUserName(String username){
        return appUserRepository.findByName(username);
    }
}
