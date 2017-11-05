package com.kds.boot.recip.controllers;

import com.kds.boot.recip.model.Category;
import com.kds.boot.recip.model.UnitOfMeasure;
import com.kds.boot.recip.repositories.CategoryRepositiry;
import com.kds.boot.recip.repositories.UnitOfMeasureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by kalpasenanayake on 4/11/17.
 */
@Controller
public class IndexController {

    Logger LOG = LoggerFactory.getLogger(IndexController.class);

    private CategoryRepositiry categoryRepositiry;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepositiry categoryRepositiry, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepositiry = categoryRepositiry;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> category = categoryRepositiry.findByDescription("American");
        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Teaspoon");

        LOG.info(category.get().toString());
        LOG.info(uom.get().toString());
        return "index";
    }
}
