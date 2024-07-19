package com.example.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGetByIdResponseDTO {
    private String username;
    private String password;
}
