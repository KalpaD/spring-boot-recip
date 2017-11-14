package com.kds.boot.recip.controllers;

import com.kds.boot.recip.model.Category;
import com.kds.boot.recip.model.UnitOfMeasure;
import com.kds.boot.recip.repositories.CategoryRepositiry;
import com.kds.boot.recip.repositories.UnitOfMeasureRepository;
import com.kds.boot.recip.services.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by kalpasenanayake on 4/11/17.
 */
@Controller
public class IndexController {

    Logger LOG = LoggerFactory.getLogger(IndexController.class);

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        LOG.info("Request received for /index");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
