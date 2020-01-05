package com.migrad.user.service.impl;

import com.migrad.user.exception.BadRequestException;
import com.migrad.user.model.Post;
import com.migrad.user.model.PostRequest;
import com.migrad.user.model.User;
import com.migrad.user.repository.PostRepository;
import com.migrad.user.repository.UserRepository;
import com.migrad.user.service.PostService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<Post> findAllPosts() {
        return IterableUtils.toList(postRepository.findAll());
    }

    @Override
    @Transactional
    public Post findPostById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Post savePost(PostRequest postRequest) {
        Optional<User> optionalUser = userRepository.findById(postRequest.getUserName());
        Optional<Post> optionalPost;
        if(postRequest.getParentPostId() != null){
            optionalPost = postRepository.findById(postRequest.getParentPostId());
        } else {
            optionalPost = Optional.empty();
        }

        if(optionalUser.isPresent()){
            Post post = Post.builder()
                    .content(postRequest.getContent())
                    .author(optionalUser.get())
                    .subject(postRequest.getSubject())
                    .build();

            optionalPost.ifPresent(post::setParent);
            post.setDateCreated(LocalDateTime.now());
            post.setDateModified(LocalDateTime.now());

            return postRepository.save(post);
        } else {
            throw new BadRequestException("Comment is not bound to a user.");
        }
    }

    @Override
    @Transactional
    public void updatePost(Long id, PostRequest postRequest) {

        postRepository.findById(id).ifPresent(existingPost -> {
            existingPost.setContent(postRequest.getContent());
            existingPost.setDateModified(LocalDateTime.now());
            postRepository.save(existingPost);
        });

    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
