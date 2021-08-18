package com.example.wizer.service;

import com.example.wizer.dto.BookDto;
import com.example.wizer.dto.UserDto;
import com.example.wizer.enumerations.UserType;
import com.example.wizer.model.Book;
import com.example.wizer.model.User;
import com.example.wizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private User user;

    public User createUser(UserDto userDto) {

        if (userDto.getEmail() == null || userDto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Please enter an email");
        }

        user = new User();
        user.setEmail(userDto.getEmail());
        user.setUserType(UserType.LIBRARY_USER);
        User newUser = userRepository.save(user);
        return newUser;
    }


    public User updateUser(UserDto userDto) {

        if (userDto.getEmail() == null || userDto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Please enter an email");
        }

        user = userRepository.findById(userDto.getId()).orElseThrow(()-> new NoSuchElementException("There is no record matching the Id" ));
        user.setEmail(userDto.getEmail());
//        user.setUserType(UserType.LIBRARY_USER);
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }


}
