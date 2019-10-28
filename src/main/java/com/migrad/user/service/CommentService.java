package com.migrad.user.service;

import com.migrad.user.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    List<Comment> findAllComments();

    Comment findCommentById(Long id);

    Comment saveComment(Comment comment);

    Comment saveComment(Long id, Comment comment);

    void delete(Long id);
}
