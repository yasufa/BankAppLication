package com.example.BankApp.user.entity;

import com.example.BankApp.account.entity.Account;
import com.example.BankApp.user.command.AppUserUpdateCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "app_user")
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @Column(name = "tc_no")
    private Long tcNo;

    @Column(name = "email")
    private String email;


    public void update(AppUserUpdateCommand command){
        if (command.getName() != null){
            name = command.getName();
        }
        if (command.getSurname() != null){
            surname = command.getSurname();
        }
        if (command.getEmail() != null){
            email = command.getEmail();
        }
    }


}
