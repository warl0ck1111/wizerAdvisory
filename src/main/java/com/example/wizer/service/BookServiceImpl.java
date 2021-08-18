package com.example.wizer.service;

import com.example.wizer.dto.BookDto;
import com.example.wizer.dto.FavoriteDto;
import com.example.wizer.exceptions.ElementAlreadyExistException;
import com.example.wizer.model.Book;
import com.example.wizer.model.User;
import com.example.wizer.repository.BookRepository;
import com.example.wizer.repository.CategoryRepository;
import com.example.wizer.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements CRUDService<Book, BookDto> {
    private Book book;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Book create(BookDto bookDto) {
        System.out.println(bookDto);
        if (bookDto.getCategory() <=0){
            throw new IllegalArgumentException("Please select a Category");
        }else {
            categoryRepository.findById(bookDto.getCategory()).orElseThrow(()-> new NoSuchElementException("Invalid Category Id"));
        }

        if (bookDto.getIsbn().isBlank()){
            throw new IllegalArgumentException("invalid ISBN");
        }
        if (bookRepository.existsByTitle(bookDto.getTitle())){
            throw new ElementAlreadyExistException(String.format("The Book with title %s already exist", bookDto.getTitle()));
        }
        if (bookRepository.existsByIsbn(bookDto.getIsbn())){
                    throw new ElementAlreadyExistException(String.format("A Book with Isbn %s already exist", bookDto.getIsbn()));
                }

        if (bookDto.getPublishedYear().isBlank()){
            throw new IllegalArgumentException("invalid published Year");
        }

        if (bookDto.getTitle().isBlank()){
            throw new IllegalArgumentException("invalid title");
        }

        book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        return bookRepository.save(book) ;
    }

    @Override
    public List<Book> create(List<BookDto> d) {

        return null;
    }

    @Override
    public Book update(BookDto bookDto) {
        if (bookDto.getCategory() <=0){
            throw new IllegalArgumentException("Please select a Category");
        }

        if (bookDto.getIsbn().isBlank()){
            throw new IllegalArgumentException("invalid ISBN");
        }

        if (bookDto.getPublishedYear().isBlank()){
            throw new IllegalArgumentException("invalid published Year");
        }

        if (bookDto.getTitle().isBlank()){
            throw new IllegalArgumentException("invalid title");
        }
        if (bookRepository.existsByTitle(bookDto.getTitle())){
            throw new ElementAlreadyExistException(String.format("The Book with title %s already exist", bookDto.getTitle()));
        }
        if (bookRepository.existsByIsbn(bookDto.getIsbn())){
            throw new ElementAlreadyExistException(String.format("A Book with Isbn %s already exist", bookDto.getIsbn()));
        }


        book = bookRepository.findById(bookDto.getId()).orElseThrow(()-> new NoSuchElementException("There is no record matching the Id" ));
        BeanUtils.copyProperties(bookDto, book);
        return bookRepository.save(book) ;
    }

    @Override
    public List<Book> update(List<BookDto> d) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        if (id <= 0) throw new IllegalArgumentException("Invalid ID supplied");
        bookRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(long id) {
        if (id <= 0)
            throw new IllegalArgumentException(String.format("Invalid Id \"%d\". Id can not be less than or equal to 0.", id));
        return bookRepository.findById(id).orElseThrow(()-> new NoSuchElementException("There is no record matching the Id "));
    }

    public Book addToFavourite(FavoriteDto favoriteDto){
        User user = userRepository.findByEmail(favoriteDto.getEmail()).orElseThrow(() -> new NoSuchElementException("There is no user with this email"));
        Book book = bookRepository.findById(favoriteDto.getBookId()).orElseThrow(() -> new NoSuchElementException("There is no book matching the Id"));
        user.getFavouriteBookCollection().add(book);
        userRepository.save(user);

        return book;

    }


    public Book removeFromFavourite(FavoriteDto favoriteDto){
        User user = userRepository.findByEmail(favoriteDto.getEmail()).orElseThrow(() -> new NoSuchElementException("There is no user with this email"));
        Book book = bookRepository.findById(favoriteDto.getBookId()).orElseThrow(() -> new NoSuchElementException("There is no book matching the Id"));
        user.getFavouriteBookCollection().remove(book);
        userRepository.save(user);
        return book;
    }

}


