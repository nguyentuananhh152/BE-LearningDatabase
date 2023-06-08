package com.example.learningdatabase.service.serviceimplement;

import com.example.learningdatabase.entity.User;
import com.example.learningdatabase.repository.UserRepository;
import com.example.learningdatabase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        try {
            if (!userRepository.existsById(user.getId())) {
                userRepository.save(user);
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateUserByID(int id, User user) {

    }

    @Override
    public void deleteUserByID(int id) {

    }

    @Override
    public boolean exist(int id) {
        if (userRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User getUserByID(int id) {
        return null;
    }
}
