package com.migrad.user.controller;

import com.migrad.user.model.Comment;
import com.migrad.user.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/migrad-community-api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> findAllComments() {
        return commentService.findAllComments();
    }

    @GetMapping("/comments/{id}")
    public Comment findCommentById(@PathVariable Long id) {
        return commentService.findCommentById(id);
    }

    @PostMapping("/comments")
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }

    @PutMapping("/comments/{id}")
    public Comment updateComment(@PathVariable Long id,
                                 @RequestBody Comment comment) {
        return commentService.saveComment(id, comment);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.delete(id);
    }
}
