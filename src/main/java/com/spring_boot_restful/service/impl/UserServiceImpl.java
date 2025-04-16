package com.spring_boot_restful.service.impl;

import com.spring_boot_restful.entity.User;
import com.spring_boot_restful.repository.UserRepository;
import com.spring_boot_restful.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    //Omit @Autowired due to there is only one parameterized constructor.
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
