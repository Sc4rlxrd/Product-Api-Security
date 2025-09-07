package com.scarlxrd.security.model.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequestDto(
        String name,
        @NotNull(message = "O preço não pode ser null")
        BigDecimal price) {
}
