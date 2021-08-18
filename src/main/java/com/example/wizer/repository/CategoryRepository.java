package com.example.wizer.repository;

import com.example.wizer.model.Book;
import com.example.wizer.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
