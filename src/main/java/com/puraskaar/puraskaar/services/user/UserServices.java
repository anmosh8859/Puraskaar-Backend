package com.puraskaar.puraskaar.services.user;

import com.puraskaar.puraskaar.entity.users.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserServices {

    public User saveUser(User user);

    public User getUserById(Long id);

    public User getUserByLoginId(String loginId);

    public List<User> getAllUsers();

    void deleteUser(User user);
}

