package com.migrad.user.service.impl;

import com.migrad.user.model.Comment;
import com.migrad.user.repository.CommentRepository;
import com.migrad.user.service.CommentService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAllComments() {
        return IterableUtils.toList(commentRepository.findAll());
    }

    @Override
    public Comment findCommentById(Long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public Comment saveComment(Comment comment) {
        comment.setDateCreated(LocalDateTime.now());
        comment.setDateModified(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    @Override
    @Transactional
    public Comment saveComment(Long id, Comment comment) {
        Comment existingComment = findCommentById(id);
        existingComment.setReplies(comment.getReplies());
        existingComment.setDateModified(LocalDateTime.now());
        return commentRepository.save(existingComment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
