package com.kds.boot.recip.repositories;

import com.kds.boot.recip.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepositiry extends CrudRepository<Category, Long> {

   Optional<Category> findByDescription(String description);
}
