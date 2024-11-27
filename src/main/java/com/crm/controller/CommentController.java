package com.crm.controller;

import com.crm.entity.Comment;
import com.crm.entity.Post;
import com.crm.payload.CommentDto;
import com.crm.repository.CommentRepository;
import com.crm.repository.PostRepository;
import com.crm.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //http://localhost:8080/api/v1/comments?postId=1
    @PostMapping
    public ResponseEntity<String> createComment(
            @RequestBody CommentDto commentDto,
            @RequestParam Long postId
    ){
        commentService.createComment(commentDto, postId);
            return new ResponseEntity<>("Comment created successfully", HttpStatus.CREATED);
    }

    //public void deleteComment
}
