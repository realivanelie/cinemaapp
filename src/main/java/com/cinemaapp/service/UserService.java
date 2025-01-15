package com.cinemaapp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cinemaapp.model.User;
import com.cinemaapp.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        logger.info("Recherche de l'utilisateur avec l'email: {}", email);
        User user = userRepository.findByEmail(email);
        if (user != null) {
            logger.info("Utilisateur trouvé : {}", email);
        } else {
            logger.warn("Utilisateur non trouvé avec l'email : {}", email);
        }
        return user;
    }

    public void save(User user) {
        logger.info("Enregistrement de l'utilisateur avec l'email: {}", user.getEmail());
        userRepository.save(user);
        logger.info("Utilisateur enregistré avec succès: {}", user.getEmail());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            logger.warn("Utilisateur non trouvé avec l'email: {}", email);
            throw new UsernameNotFoundException("Utilisateur non trouvé.");
        }
        logger.info("Utilisateur trouvé avec l'email: {}", email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
