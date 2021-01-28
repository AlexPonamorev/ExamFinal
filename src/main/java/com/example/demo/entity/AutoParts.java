package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AutoParts extends Identity{
    @Setter
    @Getter
    private String nameKey;

    @Setter
    @Getter
    private String nameValue;

    @Setter
    @Getter
    private String generation;

    @Setter
    @Getter
    @ManyToMany()
    private List<Generation> generationList = new ArrayList<>();


}
