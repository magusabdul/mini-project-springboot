package com.magusabdul.miniprojectspringboot.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.magusabdul.miniprojectspringboot.models.entities.Comment;
import com.magusabdul.miniprojectspringboot.models.repos.CommentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CommentService {
    
    @Autowired
    private CommentRepo commentRepo;

    public Comment save(Comment comment){
        return commentRepo.save(comment);
    }

    public Comment findById(Long id){
        Optional<Comment> comment = commentRepo.findById(id);
        if (!comment.isPresent()) {
            return null;
        }
        return comment.get();
    }

    public Iterable<Comment> findAll(){
        return commentRepo.findAll();
    }

    public void removeById(Long id){
        commentRepo.deleteById(id);
    }
}
