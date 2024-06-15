package app.vercel.machadoah.userapi.resources.dto;

import lombok.EqualsAndHashCode;

import java.util.UUID;

public record UserDeleteDTO(
        @EqualsAndHashCode.Include UUID id) {
}
