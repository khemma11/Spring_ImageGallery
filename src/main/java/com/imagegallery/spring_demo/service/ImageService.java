package com.imagegallery.spring_demo.service;

import com.imagegallery.spring_demo.model.Image;
import com.imagegallery.spring_demo.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

  private final ImageRepository imageRepository;

   public void save(Image image) {
    imageRepository.save(image);
  }

  public List<Image> findAll() {
    return imageRepository.findAll();
  }

  public List<Image> findAllByCategoryId(Integer id) {
    return imageRepository.findByCategoryId(id);
  }

    public void delete(int id) {
        imageRepository.deleteById(id);
    }
}
