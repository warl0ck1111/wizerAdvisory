package com.example.wizer.repository;

import com.example.wizer.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    boolean existsByTitle(String title);

    boolean existsByIsbn(String isbn);

}
