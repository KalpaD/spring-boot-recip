package com.kds.boot.recip.services;

import com.kds.boot.recip.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);
}
