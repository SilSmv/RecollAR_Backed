package com.recollar.recollar_backend.services;

import com.recollar.recollar_backend.models.CategoryModel;
import com.recollar.recollar_backend.repository.CategoryRepository;
import com.recollar.recollar_backend.repository.CollectionsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Resource
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getCategories(){
        List<CategoryModel> categories = categoryRepository.findAll();
        return categories;
    }

}
