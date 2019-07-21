package com.example.postnComment.service;

import com.example.postnComment.entity.Post;
import com.example.postnComment.exception.ResourceNotFoundException;
import com.example.postnComment.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post save(Post post){
        return postRepository.save(post);
    }

    public Post findByPost_id(Integer post_id){
        return postRepository.findById(post_id).orElseThrow(()-> new ResourceNotFoundException());
    }

    public List<Post> viewAll(){
        return postRepository.findAll();
    }

    public void delete(Integer post_id){
        postRepository.deleteById(post_id);
    }
}
