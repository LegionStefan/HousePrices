package com.example.demo.model;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

public interface HousePriceRepository extends CrudRepository<HousePrice, Integer> {

    Iterable<HousePrice> findAll(Sort sort);
}
