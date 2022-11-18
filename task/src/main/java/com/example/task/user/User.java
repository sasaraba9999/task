package com.example.task.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class User {

    //ログインされたユーザー情報の保持
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
