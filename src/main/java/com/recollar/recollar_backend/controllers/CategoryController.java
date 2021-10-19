package com.recollar.recollar_backend.controllers;

import com.recollar.recollar_backend.models.CategoryModel;
import com.recollar.recollar_backend.models.CollectionsModel;
import com.recollar.recollar_backend.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryModel> get() throws Exception {
        return categoryService.getCategories();
    }
}
