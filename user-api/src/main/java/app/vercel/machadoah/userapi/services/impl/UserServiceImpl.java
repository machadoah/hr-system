package app.vercel.machadoah.userapi.services.impl;

import app.vercel.machadoah.userapi.domain.User;
import app.vercel.machadoah.userapi.resources.dto.*;
import app.vercel.machadoah.userapi.services.exceptions.ObjectNotFoundException;
import app.vercel.machadoah.userapi.repositories.UserRepository;
import app.vercel.machadoah.userapi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDTO findById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Object not found"));
        return new UserResponseDTO(
                user.getName(),
                user.getEmail(),
                user.getHourlyPrice());
    }

    @Override
    public List<UserListDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserListDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getHourlyPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        User user = new User();
        BeanUtils.copyProperties(userRequestDTO, user);

        User savedUser = userRepository.save(user);
        return new UserResponseDTO(
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getHourlyPrice());
    }

    @Override
    public UserResponseDTO update(UUID id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        BeanUtils.copyProperties(userRequestDTO, user);

        User updatedUser = userRepository.save(user);
        return new UserResponseDTO(
                updatedUser.getName(),
                updatedUser.getEmail(),
                updatedUser.getHourlyPrice());
    }

    @Override
    public UserDeleteDTO delete(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        UserDeleteDTO userDeleteDTO = new UserDeleteDTO(user.getId());
        userRepository.delete(user);
        return userDeleteDTO;
    }

}
