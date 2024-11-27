package com.crm.service;

import com.crm.entity.Comment;
import com.crm.entity.Post;
import com.crm.payload.CommentDto;
import com.crm.repository.CommentRepository;
import com.crm.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    public CommentService(PostRepository postRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    CommentDto maptoDto(Comment comment){
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;
    }

    Comment mapToEntity(CommentDto dto){
        Comment comment = modelMapper.map(dto, Comment.class);
        return comment;
    }

    public CommentDto createComment(CommentDto commentDto, Long postId) {
        Comment comment = mapToEntity(commentDto);
        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();
        comment.setPost(post);
        Comment saved = commentRepository.save(comment);
        CommentDto dto = maptoDto(saved);
        return dto;
    }
}
