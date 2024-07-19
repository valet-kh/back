package com.example.demo.service;

import com.example.demo.dto.UserUpdateDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Пользователь с данным id не был найден."));
    }

    public void updateUser(Long id, UserUpdateDto updateDto) {
        var user = getUserById(id);
        user.setUsername(updateDto.getNewUsername());
        user.setPassword(updateDto.getNewPassword());
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        var user = getUserById(id);
        userRepository.delete(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
