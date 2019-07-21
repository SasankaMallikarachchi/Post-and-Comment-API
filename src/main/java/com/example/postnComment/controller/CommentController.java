package com.example.postnComment.controller;

import com.example.postnComment.entity.Comment;
import com.example.postnComment.entity.Post;
import com.example.postnComment.exception.ResourceNotFoundException;
import com.example.postnComment.repository.CommentRepository;
import com.example.postnComment.repository.PostRepository;
import com.example.postnComment.service.CommentService;
import com.example.postnComment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @PostMapping("post/{post_id}/comment")
    public Comment save(@Valid@RequestBody Comment comment,
                        @PathVariable(value = "post_id")Integer post_id){
        Post p = postService.findByPost_id(post_id);
        comment.setPost(p);
        return commentService.save(comment);
    }

    @GetMapping("comment/{comment_id}")
    public Comment findById(@PathVariable(value = "comment_id")Integer comment_id){
        return commentService.findById(comment_id);
    }

    @GetMapping("post/{post_id}/comment")
    public List<Comment> findByPost(@PathVariable(value = "post_id")Integer post_id){
        return commentService.findByPost(post_id);
    }

    @DeleteMapping("comment/{comment_id}")
    public void deleteById(@PathVariable(value = "comment_id")Integer comment_id){
        commentService.deleteById(comment_id);
    }

    @DeleteMapping("post/{post_id}")
    public void deleteByPost(@PathVariable(value = "post_id")Integer post_id){
        commentService.deleteByPost(post_id);
    }

   /* @GetMapping("/posts/{postId}/comments")
    public Page<Comment> getAllCommentsByPostId(@PathVariable (value = "postId") Integer postId,
                                                Pageable pageable){
        return commentRepository.findByPostId(postId,pageable);
    }

    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable (value="postId") Integer postId,
                                 @Valid @RequestBody Comment comment){
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(()-> new ResourceNotFoundException("PostId "+postId+" not found"));
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public Comment updateComment(@PathVariable (value="postId") Long postId,
                                 @PathVariable (value="commentId") Integer commentId,
                                 @Valid @RequestBody Comment commentRequest){
        if(!postRepository.existsById(postId)){
            throw new ResourceNotFoundException("postId "+postId+" not found");
        }

        return commentRepository.findById(commentId).map(comment->{
            comment.setText(commentRequest.getText());
            return commentRepository.save(comment);
        }).orElseThrow(()-> new ResourceNotFoundException(("CommentId "+commentId+" not found")));
    }*/


}
