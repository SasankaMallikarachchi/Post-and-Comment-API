package com.example.postnComment.controller;

import com.example.postnComment.entity.Post;
import com.example.postnComment.repository.PostRepository;
import com.example.postnComment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post createPost(@Valid @RequestBody Post post){
        return postService.save(post);
    }

    @GetMapping("viewAll")
    public List<Post> viewAll(){
        return postService.viewAll();
    }

    @GetMapping("/{post_id}")
    public Post getPost(@PathVariable(value = "post_id") Integer post_id){
        return postService.findByPost_id(post_id);
    }

    @PutMapping("{post_id}")
    public Post updatePost(@PathVariable(value = "post_id") Integer post_id,@Valid Post post){
        Post p1 = postService.findByPost_id(post_id);
        if(p1!= null){
            p1.setTitle(post.getTitle());
            p1.setDescription(post.getDescription());
            p1.setContent(post.getContent());
            return postService.save(p1);
        }
        return postService.save(post);
    }

    @DeleteMapping("{post_id}")
    public void delete(@PathVariable(value = "post_id") Integer post_id){
        postService.delete(post_id);
    }
}
