package com.example.demo.repository;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film,Integer> {
    @Query(value = "select  * from film",nativeQuery = true)
    List<Film> getAll();

    @Query(value = "select  * from film where release_year = ?1",nativeQuery = true)
    List<Film> getfilmByName(String name);
}
