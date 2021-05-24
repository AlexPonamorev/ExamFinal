package com.example.demo.repository;

import com.example.demo.entity.AutoParts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface AutoPartsRepo extends PagingAndSortingRepository<AutoParts,Long> {

    @Query(value = "SELECT var FROM AutoParts var WHERE UPPER(var.nameKey) = :autoPartsNameK")
    AutoParts findByTitle(@Param("autoPartsNameK") String autoPartsNameK); //вернется в  Optional<AutoParts>
}
