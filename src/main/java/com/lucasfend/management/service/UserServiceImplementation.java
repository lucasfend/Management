package com.lucasfend.management.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lucasfend.management.dto.UserDTO;
import com.lucasfend.management.model.User;
import com.lucasfend.management.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList()); 
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(this::convertToDto);
    }

    // Aux Methods
    
    // Convert User Entity to UserDTO
    private UserDTO convertToDto(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getUsername(), user.getBirthdate(), user.getPassword(), user.getRole());
    }
    
    // Convert DTO into User Entity
    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setUsername(userDTO.username());
        user.setBirthdate(userDTO.birthdate());
        user.setPassword(userDTO.password());
        user.setRole(userDTO.role());

        return user;
    }
}
