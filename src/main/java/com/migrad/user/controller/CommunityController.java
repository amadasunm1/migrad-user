package com.migrad.user.controller;

import com.migrad.user.model.Post;
import com.migrad.user.model.PostRequest;
import com.migrad.user.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community-api")
public class CommunityController {

    @Autowired
    private PostService postService;

    @GetMapping("/comments")
    public List<Post> findAllComments() {
        return postService.findAllPosts();
    }

    @GetMapping("/comments/{id}")
    public Post findCommentById(@PathVariable Long id) {
        return postService.findPostById(id);
    }

    @PostMapping("/comments")
    public Post createComment(@RequestBody PostRequest postRequest) {
        return postService.savePost(postRequest);
    }

    @PutMapping("/comments/{id}")
    public void updateComment(@PathVariable Long id,
                              @RequestBody PostRequest postRequest) {
        postService.updatePost(id, postRequest);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Long id) {
        postService.delete(id);
    }
}
