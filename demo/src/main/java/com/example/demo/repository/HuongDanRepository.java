package com.example.demo.repository;

import com.example.demo.entity.TBLHuongDan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HuongDanRepository extends JpaRepository<TBLHuongDan,Integer> {
    @Query(value = "SELECT * from TBLHuongDan", nativeQuery = true)
    List<TBLHuongDan> getAll();
}
