package com.example.BankApp.account.service;

import com.example.BankApp.account.entity.Account;
import com.example.BankApp.account.model.AccountTransferCommand;
import com.example.BankApp.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        this.accountRepository.save(account);
        return account;
    }

    @Override
    public List<Account> getAllAccount() {
        return this.accountRepository.findAll();
    }

    @Override
    public List<Account> getAllByUserId(Long id) {
        List<Account> allAccount = getAllAccount();
        List<Account> userIdList = new ArrayList<Account>();
        List<Account> deneme = new ArrayList<Account>();
        for (Account item : allAccount){
                if (item.getAppUser().getId() == id){
                    userIdList.add(item);
                }
        }
        return userIdList;
    }

    @Override
    public void deleteAccount(Long id) {
        this.accountRepository.deleteById(id);
    }

    @Override
    public void transfer(AccountTransferCommand command) throws Exception {
        Account sender = this.accountRepository.findByAccountNumber(command.getSenderAccountNumber());
        Account recipient = this.accountRepository.findByAccountNumber(command.getRecipientAccountNumber());
        if (sender.getCurrency() != recipient.getCurrency()){
            throw new Exception("Currency not equal");
        }
        if (sender.getCurrency() == recipient.getCurrency()){
              sender.setBalance(sender.getBalance() - command.getPrice());
              recipient.setBalance(recipient.getBalance() + command.getPrice());
        }
        accountRepository.save(sender);
        accountRepository.save(recipient);
    }

}
