package com.example.demo.controller;

import com.example.demo.model.HousePrice;
import com.example.demo.model.HousePriceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/housePrices")
public class HousePriceController {

    private final HousePriceRepository housePriceRepository;

    public HousePriceController(HousePriceRepository housePriceRepository) {
        this.housePriceRepository = housePriceRepository;
    }

    @GetMapping
    public Iterable<HousePrice> FindAllHousePrices() {
        return housePriceRepository.findAll(Sort.by(Sort.Direction.ASC, "date"));
    }

    @GetMapping("/{id}")
    public HousePrice FindHousePrice(@PathVariable Integer id) {
        return housePriceRepository.findById(id).orElse(null);
    }
}
