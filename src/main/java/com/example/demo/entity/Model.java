package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Model extends Identity{

    @Setter
    @Getter
    private String nameKey;

    @Setter
    @Getter
    private String nameValue;

    @Setter
    @Getter
    private String brand;

    @Setter
    @Getter
    @OneToMany(mappedBy = "model",fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Generation> model = new ArrayList<>();



}
