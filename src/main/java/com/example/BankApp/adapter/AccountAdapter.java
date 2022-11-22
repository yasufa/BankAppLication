package com.example.BankApp.adapter;

import com.example.BankApp.account.entity.Account;
import com.example.BankApp.account.model.AccountTransferCommand;
import com.example.BankApp.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountAdapter {

    private  AccountService service;
    @Autowired
    public AccountAdapter(AccountService service){
        this.service = service;
    }

    public Long createAccount(Account account){
        Account createdAccount = service.createAccount(account);
        return createdAccount.getAccountId();
    }

    public List<Account> getAllAccount(){
        return service.getAllAccount();
    }

    public void deleteAccount(Long id){
        service.deleteAccount(id);
    }

    public void transfer(AccountTransferCommand command) throws Exception {
        service.transfer(command);
    }






}
