package com.example.demo.repository;


import com.example.demo.entity.Brand;
import com.example.demo.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends JpaRepository <Brand, Long> {

    @Query(value = "SELECT b FROM Brand b WHERE b.nameValue = :name")
    public Brand getBrandByNameValue(@Param("name") String name);

    @Query(value = "SELECT b FROM Brand b WHERE b.nameKey = :name")
    public Brand getBrandByNameKey(@Param("name") String name);

    @Query(value = "SELECT b FROM Brand b")
    public List<Brand> getBrandList();
}
