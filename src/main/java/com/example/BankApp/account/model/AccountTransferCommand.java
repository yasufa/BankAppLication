package com.example.BankApp.account.model;

import com.example.BankApp.account.entity.CurrencyType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountTransferCommand {

    private Long senderAccountNumber;
    private Long recipientAccountNumber;
    private Long price;
}
