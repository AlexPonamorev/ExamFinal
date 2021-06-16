package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autoParts")
public class AutoPart {
    public AutoPart() {
    }

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "autoPart_id")
    private Long autoPart_id;

    public Long getAutoPart_id() {
        return autoPart_id;
    }

    public void setAutoPart_id(Long autoPart_id) {
        this.autoPart_id = autoPart_id;
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

    @ManyToMany()
    @JoinTable(name = "autoPartAndModel", joinColumns = @JoinColumn(name = "autoPart_id"), inverseJoinColumns = @JoinColumn(name = "model_id"))
    private List<Model> modelsList = new ArrayList<>();

    public List<Model> getModelsList() {
        return modelsList;
    }

    public void setModelsList(List<Model> modelsList) {
        this.modelsList = modelsList;
    }

}
