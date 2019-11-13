package com.migrad.user.repository;

import com.migrad.user.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {}