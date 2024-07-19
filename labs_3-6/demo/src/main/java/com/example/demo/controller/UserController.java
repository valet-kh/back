package com.example.demo.controller;


import com.example.demo.dto.UserCreationDTO;
import com.example.demo.dto.UserCreationResponseDTO;
import com.example.demo.dto.UserGetByIdResponseDTO;
import com.example.demo.dto.UserUpdateDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserGetByIdResponseDTO getUserById(@PathVariable long id) {
        var user = userService.getUserById(id);

        return modelMapper.map(user, UserGetByIdResponseDTO.class);
    }


    @PostMapping("/create_user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreationResponseDTO createUser(
            @RequestBody UserCreationDTO creationDto
    ) {
        var newUser = modelMapper.map(creationDto, User.class);

        userService.createUser(newUser);

        var userId = newUser.getId();
        return new UserCreationResponseDTO().setId(userId);
    }

    @PutMapping("/update_user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable long id, @RequestBody UserUpdateDto updateDto) {
        userService.updateUser(id, updateDto);
    }

    @DeleteMapping("/delete_user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }


    @GetMapping("/get_all_users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}