package com.magusabdul.miniprojectspringboot.controllers;

import javax.validation.Valid;

import com.magusabdul.miniprojectspringboot.dto.ResponseData;
import com.magusabdul.miniprojectspringboot.models.entities.Recipe;
import com.magusabdul.miniprojectspringboot.services.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    
    @Autowired
    private RecipeService recipeService;

    @PostMapping
    public ResponseEntity<ResponseData<Recipe>> create(@Valid @RequestBody Recipe recipe, Errors errors){
        ResponseData<Recipe> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error: errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(recipeService.save(recipe));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Recipe> findAll(){
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    public Recipe findById(@PathVariable("id") Long id){
        return recipeService.findById(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Recipe>> update(@Valid @RequestBody Recipe recipe, Errors errors){
        ResponseData<Recipe> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error: errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(recipeService.save(recipe));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable("id") Long id){
        recipeService.removeById(id);
    }
}
