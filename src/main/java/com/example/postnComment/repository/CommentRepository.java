package com.example.postnComment.repository;

import com.example.postnComment.entity.Comment;
import com.example.postnComment.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>{
    //Page<Comment> findByPostId(Long postId, Pageable pageble);
    //Optional<Comment> findByIdAndPostId(Long id, Long postId);


    @Query("select t from Comment t where t.post = :post")
    List<Comment> findByPostId(@Param("post")Post post);

    @Transactional
    @Modifying
    @Query("delete from Comment t where t.post = :post")
    void deleteByPost(@Param("post")Post post);
}
