package com.lucasfend.management.dto;

import java.util.Date;

public record UserDTO(Long id, String name,
        String email, String username,
        Date birthdate, String password, String role) {
}
