package com.migrad.user.repository;

import com.migrad.user.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {}
