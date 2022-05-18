package com.magusabdul.miniprojectspringboot.controllers;

import javax.validation.Valid;

import com.magusabdul.miniprojectspringboot.dto.ResponseData;
import com.magusabdul.miniprojectspringboot.models.entities.Comment;
import com.magusabdul.miniprojectspringboot.services.CommentService;

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
@RequestMapping("/api/comment")
public class CommentController {
    
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<ResponseData<Comment>> create(@Valid @RequestBody Comment comment, Errors errors){
        ResponseData<Comment> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error: errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(commentService.save(comment));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Comment> findAll(){
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public Comment findById(@PathVariable("id") Long id){
        return commentService.findById(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Comment>> update(@Valid @RequestBody Comment comment, Errors errors){
        ResponseData<Comment> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error: errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(commentService.save(comment));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable("id") Long id){
        commentService.removeById(id);
    }
}
