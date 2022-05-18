package com.magusabdul.miniprojectspringboot.models.repos;

import com.magusabdul.miniprojectspringboot.models.entities.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Long>{
    
}
