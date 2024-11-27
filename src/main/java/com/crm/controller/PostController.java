package com.crm.controller;

import com.crm.entity.Post;
import com.crm.payload.PostDto;
import com.crm.repository.CommentRepository;
import com.crm.repository.PostRepository;
import com.crm.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //http://localhost:8080/api/v1/posts
    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>("Post created successfully with id: " + dto.getId(), HttpStatus.CREATED);
    }

    //http://localhost:8080/api/v1/posts?id=1
    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestParam Long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post deleted Successfully", HttpStatus.OK);
    }
    }
