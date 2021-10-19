package com.recollar.recollar_backend.repository;

import com.recollar.recollar_backend.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel,Integer> {


}
