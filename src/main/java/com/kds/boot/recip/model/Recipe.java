package com.kds.boot.recip.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatic generation of the id.
    private Long id;

    @Lob // Since the description is String , Hibernate will create a CLOB(Character large object).
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob // Since the image is Byte [] , Hibernate will create a BLOB.
    private Byte [] image;

    @Enumerated(value = EnumType.STRING) // Overriding the default behaviour of storing enums as numbers to the db.
    private Difficulty difficulty;

    // Define the one to one relationship from Recipe to Note and make the recipe owner of the note by adding CascadeType.ALL
    @OneToOne(cascade =  CascadeType.ALL)
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns =  @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();
}
