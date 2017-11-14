package com.kds.boot.recip.repositories;

import com.kds.boot.recip.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescriptionTeaspoon() throws Exception {

        Optional<UnitOfMeasure> uomResult = unitOfMeasureRepository.findByDescription("Teaspoon");
        assertEquals("Teaspoon", uomResult.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() throws Exception {

        Optional<UnitOfMeasure> uomResult = unitOfMeasureRepository.findByDescription("Cup");
        assertEquals("Cup", uomResult.get().getDescription());
    }

}