package com.spring_boot_restful.service.impl;

import com.spring_boot_restful.dto.UserDto;
import com.spring_boot_restful.entity.User;
import com.spring_boot_restful.mapper.UserMapper;
import com.spring_boot_restful.repository.UserRepository;
import com.spring_boot_restful.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    //Omit @Autowired due to there is only one parameterized constructor.
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        // Convert UserDto into User JPA Entity
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        // Convert User JPA Entity to UserDto

        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user =  optionalUser.get();
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User>users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
