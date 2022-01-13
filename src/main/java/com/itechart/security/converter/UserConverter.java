package com.itechart.security.converter;

import com.itechart.security.model.User;
import com.itechart.security.model.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;

public class UserConverter {
    public static UserDetails toUserDetails(User user) {
        return UserDetailsImpl.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}