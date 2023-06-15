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
                return userRepository.save(user);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateUserByID(int id, User user) {
        // update name, image,age, address
        try {
            if (exist(id)) {
                User userUpdate = userRepository.findById(id).get();
                userUpdate.setName(user.getName());
                userUpdate.setImage(user.getImage());
                userUpdate.setNumberAge(user.getNumberAge());
                userUpdate.setAddress(user.getAddress());
                userRepository.saveAndFlush(userUpdate);
            }
        } catch (Exception e) {}
    }

    @Override
    public void deleteUserByID(int id) {
        try {
            if (exist(id)) {
                userRepository.deleteById(id);
            }
        } catch (Exception e) {
        }
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
        try {
            if (exist(id)) {
                return userRepository.findById(id).get();
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
