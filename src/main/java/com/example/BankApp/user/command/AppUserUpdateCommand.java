package com.example.BankApp.user.command;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AppUserUpdateCommand {
    private String name;
    private String surname;
    private String email;
}
