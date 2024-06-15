package app.vercel.machadoah.userapi.services;

import app.vercel.machadoah.userapi.domain.User;
import app.vercel.machadoah.userapi.resources.dto.*;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponseDTO findById(UUID id);
    List<UserListDTO> findAll();
    UserResponseDTO save(UserRequestDTO user);
    UserResponseDTO update(UUID id, UserRequestDTO user);
    UserDeleteDTO delete(UUID id);
}
