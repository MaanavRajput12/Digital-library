package com.example.DigitalLibrary.Services;

import org.springframework.stereotype.Service;

import com.example.DigitalLibrary.DTOs.Auth.RegisterUserDTO;
import com.example.DigitalLibrary.Entites.User;
import com.example.DigitalLibrary.ExceptionHandlers.BadRequestException;
import com.example.DigitalLibrary.ExceptionHandlers.ResourceNotFoundException;
import com.example.DigitalLibrary.Repositories.UserRepository;

@Service
public class UserServices {

    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ REGISTER USER (DTO → ENTITY conversion here)
    public User registerUser(RegisterUserDTO dto) {

        if (dto == null) {
            throw new BadRequestException("Registration data cannot be null");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return userRepository.save(user);
    }

    public User getUserById(Long userId) {
        if (userId == null) {
            throw new BadRequestException("User ID cannot be null");
        }

        return userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + userId));
    }

    public User login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new BadRequestException("Invalid credentials");
        }

        return user;
    }
}
