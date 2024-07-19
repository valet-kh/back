package com.example.demo.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserCreationDTO {
    private String username;
    private String password;
}
