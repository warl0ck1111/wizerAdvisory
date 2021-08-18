package com.example.wizer.model;

import com.example.wizer.enumerations.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "EMAIL", nullable = false)
    private String email;


    @Enumerated(EnumType.STRING)
    private UserType userType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_BOOKS",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id")
    )
    private Collection<Book> favouriteBookCollection;

    public User(String email, UserType userType, Collection<Book> favouriteBookCollection) {
        this.email = email;
        this.userType = userType;
        this.favouriteBookCollection = favouriteBookCollection;
    }
}

