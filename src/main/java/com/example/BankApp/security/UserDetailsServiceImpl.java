package com.example.BankApp.security;

import com.example.BankApp.user.entity.AppUser;
import com.example.BankApp.user.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private AppUserRepository appUserRepository;

    public UserDetailsServiceImpl(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.findByName(username);
        return JwtUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id){
        AppUser user = appUserRepository.findById(id).get();
        return JwtUserDetails.create(user);
    }
}
