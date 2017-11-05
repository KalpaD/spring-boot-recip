package com.kds.boot.recip.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Ingredient ingredient;
    private String description;
}
