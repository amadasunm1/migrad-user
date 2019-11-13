package com.migrad.user.service;

import com.migrad.user.model.Post;
import com.migrad.user.model.PostRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<Post> findAllPosts();

    Post findPostById(Long id);

    Post savePost(PostRequest post);

    void updatePost(Long id, PostRequest post);

    void delete(Long id);
}
