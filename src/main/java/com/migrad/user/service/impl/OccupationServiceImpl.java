package com.migrad.user.service.impl;

import com.migrad.user.model.Occupation;
import com.migrad.user.repository.OccupationRepository;
import com.migrad.user.service.OccupationService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OccupationServiceImpl implements OccupationService {
    @Autowired
    OccupationRepository occupationRepository;

    @Override
    @Transactional
    public List<Occupation> findAll() {
        return IterableUtils.toList(occupationRepository.findAll());
    }

}
