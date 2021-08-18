package com.example.wizer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Column(name = "TITLE")
    private String title;

    @Column(name = "ISBN")
    private String isbn;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd h:m:s")
    @Column(name = "PUBLISHED_YEAR")
    private LocalDate publishedYear;

    @JoinColumn(name = "CATEGORY_FK", referencedColumnName = "ID")
    @OneToOne(optional = true)
    private Category category;

    public Book(String title, String isbn, LocalDate publishedYear, Category category) {
        this.title = title;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
        this.category = category;
    }
}
