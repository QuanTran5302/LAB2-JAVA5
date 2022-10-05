package com.example.demo.repository;

import com.example.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "select  * from category",nativeQuery = true)
    List<Category> getAll();

    @Query(value = "select * from  category where name like ?1",nativeQuery = true)
    List<Category> getcategoryByName(String name);

}