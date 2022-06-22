package com.softuni.bg.exam_prep.service;

import com.softuni.bg.exam_prep.model.entity.Category;
import com.softuni.bg.exam_prep.model.entity.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByCategoryName(CategoryName categoryName);
}
