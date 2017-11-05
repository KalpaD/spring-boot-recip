package com.kds.boot.recip.repositories;

import com.kds.boot.recip.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
