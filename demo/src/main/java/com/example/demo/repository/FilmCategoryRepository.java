package com.example.demo.repository;

import com.example.demo.entity.FilmCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategory,Integer> {
    @Query(value = "select * from film_category",nativeQuery = true)
    List<FilmCategory> getAll();
}
