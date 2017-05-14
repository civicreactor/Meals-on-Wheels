package com.meals.on.wheels.models;


import com.meals.on.wheels.enums.MealType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MEAL")
public class MealModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name= "MEAL_ID")
    private Long id;
    private MealType type;
    private String description;
    private Boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MealType getType() {
        return type;
    }

    public void setType(MealType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
