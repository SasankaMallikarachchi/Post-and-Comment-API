package com.example.postnComment.service;

import com.example.postnComment.entity.Comment;
import com.example.postnComment.entity.Post;
import com.example.postnComment.exception.ResourceNotFoundException;
import com.example.postnComment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostService postService;

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public Comment findById(Integer comment_id){
        return commentRepository.findById(comment_id).orElseThrow(() ->new ResourceNotFoundException());
    }

    public List<Comment> findByPost(Integer post_id){
        Post p = postService.findByPost_id(post_id);
        return commentRepository.findByPostId(p);
    }

    public void deleteById(Integer comment_id){
        commentRepository.deleteById(comment_id);
    }

    public void deleteByPost(Integer post_id){
        Post p = postService.findByPost_id(post_id);
        commentRepository.deleteByPost(p);
    }
}
