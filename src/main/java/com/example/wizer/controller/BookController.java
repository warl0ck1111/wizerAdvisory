package com.example.wizer.controller;

import com.example.wizer.dto.BookDto;
import com.example.wizer.dto.FavoriteDto;
import com.example.wizer.model.Book;
import com.example.wizer.response.JsonResponse;
import com.example.wizer.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@RequestBody BookDto dto) {


        Book book = bookService.create(dto);
        return new ResponseEntity<>(new JsonResponse(HttpStatus.OK, String.format("%s created Successfully.", book.getTitle()), book), HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editBook(@RequestBody BookDto dto) {

        Book book = bookService.create(dto);
        return new ResponseEntity<>(new JsonResponse(HttpStatus.OK, String.format("%s updated Successfully.", book.getTitle()),book), HttpStatus.OK);
    }


    @GetMapping("/list")
    public ResponseEntity<?> listBooks() {
        return new ResponseEntity<>(new JsonResponse(bookService.findAll()), HttpStatus.OK);
    }

    @PostMapping("/add-favourite")
    public ResponseEntity<?> addBookFavourite(@RequestBody FavoriteDto favoriteDto) {
        Book book = bookService.addToFavourite(favoriteDto);
        return new ResponseEntity<>(new JsonResponse(HttpStatus.OK, String.format("%s Added to Favourite Successfully.", book.getTitle())), HttpStatus.OK);
    }

    @PostMapping("/remove-favourite")
    public ResponseEntity<?> removeBookFromFavourite(@RequestBody FavoriteDto favoriteDto) {
        Book book = bookService.addToFavourite(favoriteDto);
        return new ResponseEntity<>(new JsonResponse(HttpStatus.OK, String.format("%s Added to Favourite Successfully.", book.getTitle())), HttpStatus.OK);
    }
}
