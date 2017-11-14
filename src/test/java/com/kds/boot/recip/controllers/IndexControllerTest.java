package com.kds.boot.recip.controllers;

import com.kds.boot.recip.model.Difficulty;
import com.kds.boot.recip.model.Recipe;
import com.kds.boot.recip.services.RecipeService;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexControllerTest {

    @Mock
    private RecipeService recipeService;

    @Mock
    private Model model;

    @InjectMocks
    private IndexController indexController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this.getClass());
    }

    @Test
    public void testGetIndexPage() throws Exception {

        Set<Recipe> recipes = new HashSet<>();

        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        recipes.add(tacosRecipe);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        when(recipeService.getRecipes()).thenReturn(recipes);

        when(model.addAttribute("recipes", recipes)).thenReturn(model);

        String indexPage = indexController.getIndexPage(model);

        verify(model,
                times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

        verify(recipeService, times(1)).getRecipes();

        assertThat(indexPage, is("index"));

        Set<Recipe> setInController = argumentCaptor.getValue();

        assertThat(setInController, hasSize(1));
    }
}
