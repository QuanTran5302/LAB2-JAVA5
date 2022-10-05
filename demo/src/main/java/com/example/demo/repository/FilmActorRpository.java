package com.example.demo.repository;

import com.example.demo.entity.Actor;
import com.example.demo.entity.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmActorRpository extends JpaRepository<FilmActor,Integer> {
    @Query(value = "select  * from film_actor",nativeQuery = true)
    List<FilmActor> getAll();
}
