package com.example.learningdatabase.service;

import com.example.learningdatabase.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void saveUser(User user);

    // update name, image, age, address, isadmin
    public void updateUserByID(int id, User user);

    public void deleteUserByID(int id);

    public User getUserByID(int id);

}
