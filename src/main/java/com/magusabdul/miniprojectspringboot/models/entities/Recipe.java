package com.magusabdul.miniprojectspringboot.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_recipe")
public class Recipe implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required")
    @Column(name = "recipe_name", length = 200)
    private String name;

    @NotEmpty(message = "Description is required")
    @Column(name = "recipe_description", length = 2000)
    private String description;

    @CreationTimestamp
    private LocalDateTime created_at;

    @ManyToOne
    private AppUser appUser;
}
