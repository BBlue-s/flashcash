package com.example.flashcash.service;

import com.example.flashcash.repository.UserRepository;
import org.apache.el.stream.Optional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthentificationService implements UserDetailsService {

    private final UserRepository userRepository;
    public AuthentificationService(UserRepository userRepository) {this.userRepository = userRepository}

    @Override
    public UserDetails loadUserByUsername(String s)throws UsernameNotFoundException {
        Optional<User> user = userRepository
                .findUserByEmail(s);
        if (user.isPresent()) {
            return new org.springframework.security.core.userdetails.User(user.get().getEmail(),user.get().getPassword(), new ArrayList<>());
        }
        throw new UsernameNotFoundException(s);
    }
}