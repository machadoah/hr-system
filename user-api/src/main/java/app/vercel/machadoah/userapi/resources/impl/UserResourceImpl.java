package app.vercel.machadoah.userapi.resources.impl;

import app.vercel.machadoah.userapi.domain.User;
import app.vercel.machadoah.userapi.resources.UserResource;
import app.vercel.machadoah.userapi.resources.dto.UserDeleteDTO;
import app.vercel.machadoah.userapi.resources.dto.UserListDTO;
import app.vercel.machadoah.userapi.resources.dto.UserRequestDTO;
import app.vercel.machadoah.userapi.resources.dto.UserResponseDTO;
import app.vercel.machadoah.userapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/users")
public class UserResourceImpl implements UserResource{

    private final UserService userService;

    @Override
    public ResponseEntity<UserResponseDTO> findById(UUID id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @Override
    public ResponseEntity<List<UserListDTO>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @Override
    public ResponseEntity<UserResponseDTO> save(UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userRequestDTO));
    }

    @Override
    public ResponseEntity<UserResponseDTO> update(UUID id, UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok().body(userService.update(id, userRequestDTO));
    }

    @Override
    public ResponseEntity<UserDeleteDTO> delete(UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
