package com.example.BankApp.account.repository;

import com.example.BankApp.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByAccountNumber(Long accountNumber);

//    @Query("select * from bank.accounts where user_id = 1")
//    List<AccountDto> findAllByUserId(Long userId);
}
