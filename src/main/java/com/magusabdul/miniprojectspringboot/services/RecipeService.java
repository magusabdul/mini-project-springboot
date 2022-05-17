package com.magusabdul.miniprojectspringboot.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.magusabdul.miniprojectspringboot.models.entities.Recipe;
import com.magusabdul.miniprojectspringboot.models.repos.RecipeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RecipeService {
    
    @Autowired
    private RecipeRepo recipeRepo;

    public Recipe save(Recipe recipe){
        return recipeRepo.save(recipe);
    }

    public Recipe findById(Long id){
        Optional<Recipe> recipe = recipeRepo.findById(id);
        if (!recipe.isPresent()) {
            return null;
        }
        return recipeRepo.findById(id).get();
    }

    public Iterable<Recipe> findAll(){
        return recipeRepo.findAll();
    }

    public void removeById(Long id){
        recipeRepo.deleteById(id);
    }

}
