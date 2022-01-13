package com.itechart.security.controller;

import com.itechart.security.model.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import com.itechart.security.model.User;
import com.itechart.security.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String mainPage() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/userList")
    public String userList(Model model, @AuthenticationPrincipal UserDetailsImpl currentUser) {
        model.addAttribute("authenticatedUser", currentUser);
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "userList";
    }
}