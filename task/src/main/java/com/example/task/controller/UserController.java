package com.example.task.controller;

import com.example.task.user.UserForm;
import com.example.task.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @GetMapping("/createUser")
    public String showCreateUserForm (@ModelAttribute UserForm userForm){
        return "users/createUser";
    }

    @PostMapping
    public String create(@Validated UserForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return  showCreateUserForm(form);
        }
        userService.create(form.getUsername(),form.getPassword());
        return "redirect:/";
    }


}
