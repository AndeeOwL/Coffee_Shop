package com.softuni.bg.exam_prep.service.impl;

import com.softuni.bg.exam_prep.model.entity.Category;
import com.softuni.bg.exam_prep.model.entity.CategoryName;
import com.softuni.bg.exam_prep.repository.CategoryRepository;
import com.softuni.bg.exam_prep.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if(categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryName.values())
                .forEach(categoryName -> {
            Category category = new Category();
            category.setName(categoryName);
            switch (categoryName){
                case CAKE -> category.setNeededTime(10);
                case DRINK -> category.setNeededTime(1);
                case COFFEE -> category.setNeededTime(2);
                case OTHER -> category.setNeededTime(5);
            }

            categoryRepository.save(category);

        });

    }

    @Override
    public Category findByCategoryName(CategoryName categoryName) {
        return categoryRepository.findByName(categoryName).orElse(null);
    }
}
