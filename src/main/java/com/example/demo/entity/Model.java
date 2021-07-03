package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "models")
public class Model {
    public Model() {
    }

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long model_id;

    public Long getModel_id() {
        return model_id;
    }

    public void setModel_id(Long model_id) {
        this.model_id = model_id;
    }

    private String nameKey;

    public String getNameKey() {
        return nameKey;
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }


    private String nameValue;

    public String getNameValue() {
        return nameValue;
    }

    public void setNameValue(String nameValue) {
        this.nameValue = nameValue;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @ManyToMany(mappedBy = "modelsList", fetch = FetchType.LAZY)
    private List<AutoPart> autoPartsList = new ArrayList<>();

    public List<AutoPart> getAutoPartsList() {
        return autoPartsList;
    }

    public void setAutoPartsList(List<AutoPart> autoPartsList) {
        this.autoPartsList = autoPartsList;
    }


    @ManyToMany(mappedBy = "modelsList", fetch = FetchType.LAZY)
    private List<Generation> generationList = new ArrayList<>();

    public List<Generation> getGenerationList() {
        return generationList;
    }

    public void setGenerationList(List<Generation> generationList) {
        this.generationList = generationList;
    }


}
