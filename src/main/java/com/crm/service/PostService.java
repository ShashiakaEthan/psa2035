package com.crm.service;

import com.crm.entity.Post;
import com.crm.payload.PostDto;
import com.crm.repository.CommentRepository;
import com.crm.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;


    public PostService(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    PostDto maptoDto(Post post){
        PostDto dto = modelMapper.map(post, PostDto.class);
        return dto;
    }

    Post maptoEntity(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }


    public PostDto createPost(PostDto postDto) {
        Post post = maptoEntity(postDto);
        Post saved = postRepository.save(post);
        PostDto dto = maptoDto(saved);
        return dto;
    }

    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
}
