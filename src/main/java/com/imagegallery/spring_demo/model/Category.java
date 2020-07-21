package com.imagegallery.spring_demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="category")


public class Category {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String picUrl;

}




