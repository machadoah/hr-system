package app.vercel.machadoah.userapi.resources.dto;

import lombok.EqualsAndHashCode;

import java.util.UUID;

public record UserListDTO(
        @EqualsAndHashCode.Include UUID id,
        String name,
        String email,
        Double hourlyPrice) {
}
