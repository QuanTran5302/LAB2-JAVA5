package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "film_actor")
@Entity
@Getter
@Setter
public class FilmActor {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;
    private Integer filmId;
    private String lastUpdate;
}
