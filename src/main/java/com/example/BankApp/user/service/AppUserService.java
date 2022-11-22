package com.example.BankApp.user.service;

import com.example.BankApp.account.entity.Account;
import com.example.BankApp.account.model.AccountTransferCommand;
import com.example.BankApp.user.command.AppUserUpdateCommand;
import com.example.BankApp.user.entity.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser createUser(AppUser appUser);

    List<AppUser> getAllAppUser();

    AppUser updateUser(Long id, AppUserUpdateCommand command);

    AppUser getOneUserByUserName(String username);
    List<Account> getAllAccountByUserId(Long id);
}
