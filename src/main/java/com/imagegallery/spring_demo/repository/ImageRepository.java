package com.imagegallery.spring_demo.repository;

import com.imagegallery.spring_demo.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,Integer> {

    List<Image> findByCategoryId(Integer id);
}
