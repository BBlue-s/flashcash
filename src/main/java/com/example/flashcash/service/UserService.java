package com.example.flashcash.service;

import com.example.flashcash.model.User;
import com.example.flashcash.model.UserAccount;
import com.example.flashcash.repository.AccountRepository;
import com.example.flashcash.repository.UserRepository;
import com.example.flashcash.service.form.SignUpForm;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service ("UserService")
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository ;
    private final AccountRepository accountRepository;


    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, AccountRepository accountRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

public User registration(SignUpForm form) {
        User user = new User();
        UserAccount account = new UserAccount();
        account.setAmount(0.0);
        user.setAccount(account);
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        return userRepository.save(user);

}

public Iterable<User> getUsers(){return userRepository.findAll();}

    public User findUser(){
        org.springframework.security.core.userdetails.User springUser =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findUserByEmail(springUser.getUsername())
                .orElseThrow(()-> new RuntimeException("user with email not found"));
    }

   // public void addIban(final) AddIbanForm form) {
   // UserAccount account = sessionService.sessionUser().getAccount();
    // account.setIban(form.getIban());
   // userAccountRepository.save(account);
   //  }
    }

