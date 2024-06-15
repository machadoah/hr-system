package app.vercel.machadoah.userapi.resources.dto;

import lombok.EqualsAndHashCode;

import java.util.UUID;

public record UserResponseDTO(
        String name,
        String email,
        Double hourlyPrice) {
}
