package com.magusabdul.miniprojectspringboot.models.repos;

import com.magusabdul.miniprojectspringboot.models.entities.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long>{
    
}
