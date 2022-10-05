package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "film_category")
@Entity
@Getter
@Setter
public class FilmCategory {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;
    private Integer categoryId;
    private String lastUpdate;
}
