package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "generations")
public class Generation {
    public Generation() {
    }

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private Long generation_id;

    public Long getGeneration_id() {
        return generation_id;
    }

    public void setGeneration_id(Long generation_id) {
        this.generation_id = generation_id;
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

    @ManyToMany
    @JoinTable(name = "generationAndModels", joinColumns = @JoinColumn(name = "generation_id"), inverseJoinColumns = @JoinColumn(name = "models_id"))
    private List<Model> modelsList;

    public List<Model> getModelsList() {
        return modelsList;
    }

    public void setModelsList(List<Model> modelsList) {
        this.modelsList = modelsList;
    }

}
