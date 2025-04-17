package com.spring_boot_restful.mapper;

import com.spring_boot_restful.dto.UserDto;
import com.spring_boot_restful.entity.User;

public class UserMapper {

    // Convert from User JPA Entity into UserDTO
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    };

    // Convert from UserDTO to User JPA Entity
    public static User mapToUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    };
}
