package com.example.demo.controller;

import com.example.demo.model.HousePrice;
import com.example.demo.model.HousePriceRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/housePrices")
public class HousePriceController {

    private final HousePriceRepository housePriceRepository;

    public HousePriceController(HousePriceRepository housePriceRepository) {
        this.housePriceRepository = housePriceRepository;
    }

    @GetMapping
    public Iterable<HousePrice> FindAllHousePrices() {
        return housePriceRepository.findAll();
    }

    @GetMapping("/{id}")
    public HousePrice FindHousePrice(@PathVariable Integer id) {
        return housePriceRepository.findById(id).orElse(null);
    }
}
