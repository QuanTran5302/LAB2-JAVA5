package com.example.demo.repository;

import com.example.demo.entity.Actor;
import com.example.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query(value = "select  * from address",nativeQuery = true)
    List<Address> getAll();

    @Query(value = "select  * from address where address like ?1",nativeQuery = true)
    List<Address> getAddressByName(String name);
}
