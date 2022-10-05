package com.example.demo.repository;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
    @Query(value = "select  * from actor",nativeQuery = true)
    List<Actor> getAll();

    @Query(value = "select  * from actor where actor_id  =?1",nativeQuery = true)
    List<Actor> getactorByName(Integer name);
}
