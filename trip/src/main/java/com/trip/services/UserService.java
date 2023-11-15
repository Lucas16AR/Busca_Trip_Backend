package com.trip.services;

import com.trip.models.UserModel;
import com.trip.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel addUser(UserModel user) {
        return userRepository.save(user);
    }

    public UserModel updateUser(Long id, UserModel user) {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserModel existingUser = optionalUser.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setGender(user.getGender());
            existingUser.setAge(user.getAge());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setLastname(user.getLastname());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserModel getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
