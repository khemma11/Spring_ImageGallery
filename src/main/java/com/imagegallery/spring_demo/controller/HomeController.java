package com.imagegallery.spring_demo.controller;

import com.imagegallery.spring_demo.model.Category;
import com.imagegallery.spring_demo.model.Image;
import com.imagegallery.spring_demo.service.HomeService;
import com.imagegallery.spring_demo.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;
    private final ImageService imageService;


    @Value("${file.upload.dir}")
    private String uploadDir;

    @GetMapping("/")
    public String homePage(@RequestParam(name = "id",required = false) Integer id, ModelMap model) {
        List<Image> allByCategoryId = imageService.findAllByCategoryId(id);
        List<Category> all = homeService.findAll();
        model.addAttribute("category", all);
        model.addAttribute("allByCategoryId", allByCategoryId);
        return "index";
    }


    @GetMapping("/images")
    public String imageByCat(@RequestParam("id") int id, Model model) {
        List<Image> allByCategoryId = imageService.findAllByCategoryId(id);
        model.addAttribute("imgByCateg", allByCategoryId);
        return "images";
    }
    
         @GetMapping(
                    value = "/image",
                    produces = MediaType.IMAGE_JPEG_VALUE
            )
            public @ResponseBody
            byte[] getImage(@RequestParam("name") String imageName) throws IOException {
                InputStream in = new FileInputStream(uploadDir + File.separator + imageName);
                return IOUtils.toByteArray(in);
            }


//    @GetMapping("/delete")
//    public String deleteCategory(@RequestParam ("id") int id){
//     homeService.delete(id);
//     return "admin";
//    }


}