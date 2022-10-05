package com.example.demo.repository;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Category;
import com.example.demo.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
    @Query(value = "select  * from language",nativeQuery = true)
    List<Language> getAll();

    @Query(value = "select  * from language where name like ?1",nativeQuery = true)
    List<Language> getLanguageByName(String name);
}
