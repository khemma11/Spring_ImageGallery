package com.imagegallery.spring_demo.controller;


import com.imagegallery.spring_demo.model.Category;
import com.imagegallery.spring_demo.model.Image;
import com.imagegallery.spring_demo.service.HomeService;
import com.imagegallery.spring_demo.service.ImageService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ImageController {
    private final HomeService homeService;
    private final ImageService imageService;


    @Value("${file.upload.dir}")
    private String uploadDir;


    @RequestMapping("/admin")
    public String admin(Model model) {
        List<Category> all = homeService.findAll();
        model.addAttribute("categories", all);
        return "admin";
    }

    @RequestMapping("/addImage")
    public String addImg(@ModelAttribute Image image, @RequestParam("image") MultipartFile file) throws IOException {
        String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File img = new File(uploadDir,name);
        file.transferTo(img);
        image.setPicUrl(name);
        imageService.save(image);
        return "redirect:/admin";
    }
    @RequestMapping("/addCategory")
    public String addCategory(@ModelAttribute Category category, @RequestParam("image") MultipartFile file) throws IOException {
        String name = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File image = new File(uploadDir,name);
        file.transferTo(image);
        category.setPicUrl(name);
        homeService.save(category);
        return "redirect:/admin";
    }


//    @GetMapping("/delete")
//    public String deleteImage(@RequestParam("id") int id){
//        imageService.delete(id);
//        return "redirect:/admin";
//    }




}

