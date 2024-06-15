package app.vercel.machadoah.userapi.resources;

import app.vercel.machadoah.userapi.domain.User;
import app.vercel.machadoah.userapi.resources.dto.UserDeleteDTO;
import app.vercel.machadoah.userapi.resources.dto.UserListDTO;
import app.vercel.machadoah.userapi.resources.dto.UserRequestDTO;
import app.vercel.machadoah.userapi.resources.dto.UserResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


public interface UserResource {

    @GetMapping(value = "/{id}")
    ResponseEntity<UserResponseDTO> findById(@PathVariable UUID id);

    @GetMapping
    ResponseEntity<List<UserListDTO>> findAll();

    @PostMapping
    ResponseEntity<UserResponseDTO> save(
            @RequestBody UserRequestDTO userRequestDTO);

    @PutMapping(value = "/{id}")
    ResponseEntity<UserResponseDTO> update(
            @PathVariable UUID id,
            UserRequestDTO userRequestDTO);

    @DeleteMapping(value = "/{id}")
    ResponseEntity<UserDeleteDTO> delete(@PathVariable UUID id);

}
