package com.imagegallery.spring_demo.repository;

import com.imagegallery.spring_demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
