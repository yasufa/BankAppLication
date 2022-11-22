package com.example.BankApp.account.service;

import com.example.BankApp.account.entity.Account;
import com.example.BankApp.account.model.AccountTransferCommand;

import java.util.List;

public interface AccountService{
    Account createAccount(Account account);

    List<Account> getAllAccount();

    List<Account> getAllByUserId(Long id);

    void deleteAccount(Long id);

    void transfer(AccountTransferCommand command) throws Exception;
}
