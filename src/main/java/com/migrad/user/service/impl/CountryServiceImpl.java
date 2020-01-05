package com.migrad.user.service.impl;

import com.migrad.user.model.Country;
import com.migrad.user.repository.CountryRepository;
import com.migrad.user.service.CountryService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;

    @Override
    @Transactional
    public List<Country> findAll() {
        return IterableUtils.toList(countryRepository.findAll());
    }
}
