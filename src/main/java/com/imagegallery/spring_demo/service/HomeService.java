package com.imagegallery.spring_demo.service;

import com.imagegallery.spring_demo.model.Category;
import com.imagegallery.spring_demo.model.Image;
import com.imagegallery.spring_demo.repository.CategoryRepository;
import com.imagegallery.spring_demo.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {



    private final CategoryRepository categoryRepository;


    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }


    public void delete (int id) {
        categoryRepository.deleteById(id);

    }
}
