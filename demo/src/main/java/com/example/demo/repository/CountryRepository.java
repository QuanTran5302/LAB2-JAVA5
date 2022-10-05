package com.example.demo.repository;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
    @Query(value = "select  * from country",nativeQuery = true)
    List<Country> getAll();

    @Query(value = "select  * from country where country like ?1",nativeQuery = true)
    List<Country> getCountryByName(String name);
}
