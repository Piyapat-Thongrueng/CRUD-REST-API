package com.spring_boot_restful.service;

import com.spring_boot_restful.dto.UserDto;
import com.spring_boot_restful.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
