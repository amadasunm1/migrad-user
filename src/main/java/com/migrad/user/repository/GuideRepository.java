package com.migrad.user.repository;

import com.migrad.user.model.Guide;
import org.springframework.data.repository.CrudRepository;

public interface GuideRepository extends CrudRepository<Guide, Long> {

    Guide findGuideByUser (String username);
}
