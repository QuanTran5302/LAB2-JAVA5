package com.example.demo.repository;

import com.example.demo.entity.Actor;
import com.example.demo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
    @Query(value = "select  * from city",nativeQuery = true)
    List<City> getAll();

    @Query(value = "select  * from city where city like ?1",nativeQuery = true)
    List<City> getCityByName(String name);
}
