package com.example.task.user;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
public class UserForm {

    //ユーザー登録で入力された名前とパスワードの保持
    @NotBlank
    public String username;
    @NotBlank
    public String password;
}
