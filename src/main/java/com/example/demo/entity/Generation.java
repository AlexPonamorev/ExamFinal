package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Generation extends Identity{
    @Setter
    @Getter
    private String nameKey;

    @Setter
    @Getter
    private String nameValue;

    @Setter
    @Getter
    private String model;

    @Setter
    @Getter
    @ManyToMany(mappedBy = "generation",fetch = FetchType.LAZY)
    public List<AutoParts> autoParts = new ArrayList<>();
}
