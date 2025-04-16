package com.spring_boot_restful.repository;

import com.spring_boot_restful.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
