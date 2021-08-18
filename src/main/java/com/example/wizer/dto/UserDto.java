package com.example.wizer.dto;

import com.example.wizer.enumerations.UserType;
import com.example.wizer.model.Book;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
public class UserDto {
    private Long id;

    private String email;


    private String userType;


    private long books;
}
