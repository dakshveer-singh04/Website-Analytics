package org.websiteanalytics.ecomsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.websiteanalytics.ecomsite.dtos.UserRegisterationDTO;
import org.websiteanalytics.ecomsite.models.User;
import org.websiteanalytics.ecomsite.repsitories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordService passwordService;

    public UserService(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(UserRegisterationDTO registrationDTO) {
        validateRegistrationDTO(registrationDTO);

        // Create a new User entity
        User newUser = new User();
        newUser.setUsername(registrationDTO.getUsername());
        newUser.setEmail(registrationDTO.getEmail());
        // Encode password before storing in the database
        newUser.setPassword(passwordService.encodePassword(registrationDTO.getPassword()));

        // Save the user using UserRepository
        return userRepository.save(newUser);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    private void validateRegistrationDTO(UserRegisterationDTO registrationDTO) {
        if (registrationDTO == null) {
            throw new IllegalArgumentException("Registration DTO must not be null.");
        }

        if (userRepository.existsByUsername(registrationDTO.getUsername())) {
            throw new RuntimeException("Username already exists.");
        }

        if (userRepository.existsByEmail(registrationDTO.getEmail())) {
            throw new RuntimeException("Email already exists.");
        }
    }
}
