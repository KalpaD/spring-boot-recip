package com.kds.boot.recip.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne // No cascade type since notes own by recipe.
    private Recipe recipe;
    @Lob
    private String recipeNotes;
}
