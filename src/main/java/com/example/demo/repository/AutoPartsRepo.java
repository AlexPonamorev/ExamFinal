package com.example.demo.repository;

import com.example.demo.entity.AutoPart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface AutoPartsRepo extends PagingAndSortingRepository<AutoPart,Long> {

    @Query(value = "SELECT a FROM AutoPart a WHERE  a.autoPart_id = :autoPartsName")
    AutoPart findByTitle(@Param("autoPartsName") String autoPartsName); //вернется в  Optional<AutoParts>
}
