package com.example.wizer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;

@Data
public class BookDto {

    @JsonIgnore
    private Long id;
    private String title;

    private String isbn;

    private String publishedYear;
    private long category;


}
