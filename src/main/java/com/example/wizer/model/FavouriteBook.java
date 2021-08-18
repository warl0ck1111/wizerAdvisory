package com.example.wizer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class FavouriteBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @JoinColumn(name = "CATEGORY_FK", referencedColumnName = "ID")
    @OneToOne(optional = true)
    private Category category;

    @JoinColumn(name = "USER_FK", referencedColumnName = "ID")
    @OneToOne(optional = true)
    private User user;
}
