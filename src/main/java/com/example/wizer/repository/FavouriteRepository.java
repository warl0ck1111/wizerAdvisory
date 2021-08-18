package com.example.wizer.repository;

import com.example.wizer.model.FavouriteBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteRepository extends JpaRepository<FavouriteBook, Long> {
}
