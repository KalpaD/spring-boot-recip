package com.kds.boot.recip.repositories;

import com.kds.boot.recip.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepositiry extends CrudRepository<Category, Long> {

}
