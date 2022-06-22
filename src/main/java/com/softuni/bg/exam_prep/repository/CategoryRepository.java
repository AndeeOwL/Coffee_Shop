package com.softuni.bg.exam_prep.repository;

import com.softuni.bg.exam_prep.model.entity.Category;
import com.softuni.bg.exam_prep.model.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryName name);
}
