package com.scarlxrd.security.model.dto;

import com.scarlxrd.security.model.entities.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
