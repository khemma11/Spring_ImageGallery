package com.imagegallery.spring_demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="image")


public class Image {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private LocalDate uploadDate;

    private String picUrl;

}




