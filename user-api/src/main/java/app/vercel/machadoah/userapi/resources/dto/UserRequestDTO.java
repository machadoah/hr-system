package app.vercel.machadoah.userapi.resources.dto;

public record UserRequestDTO(
        String name,
        String email,
        String password,
        Double hourlyPrice) {
}
