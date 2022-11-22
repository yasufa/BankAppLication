package com.example.BankApp.controller;

import com.example.BankApp.model.request.UserRequest;
import com.example.BankApp.security.JwtTokenProvider;
import com.example.BankApp.user.entity.AppUser;
import com.example.BankApp.user.service.AppUserService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    private AppUserService appUserService;
    private PasswordEncoder passwordEncoder;
    public AuthController(
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider,
            AppUserService appUserService,
            PasswordEncoder passwordEncoder
    ){
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.appUserService = appUserService;
        this.passwordEncoder = passwordEncoder;
    }


    @PreAuthorize("permitAll()")
    @PostMapping("/login")
    public String login(@RequestBody UserRequest request){
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getUserName(),request.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(auth);
        return "Bearer" +jwtToken;
    }

    @PostMapping("signin")
    public ResponseEntity<String> signIn(@RequestBody UserRequest request){
        if (appUserService.getOneUserByUserName(request.getUserName()) != null)
            return new ResponseEntity<>("Username already in use", HttpStatus.BAD_REQUEST);

        AppUser user = new AppUser();
        user.setName(request.getUserName());
        user.setPassword(request.getPassword());
        appUserService.createUser(user);
        return new ResponseEntity<>("User oluşturuldu.", HttpStatus.CREATED);

    }

}
