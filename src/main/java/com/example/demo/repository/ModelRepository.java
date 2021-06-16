package com.example.demo.repository;

import com.example.demo.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {


    @Query(value = "SELECT m FROM Model m WHERE m.nameValue = :nameValue")
    Model getModelByName(String nameValue);
}
