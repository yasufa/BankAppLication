package com.example.BankApp.account.entity;

import com.example.BankApp.user.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "currency")
    private CurrencyType currency;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private AppUser appUser;





}
