package com.example.demo.controller;

import com.example.demo.model.HousePrice;
import com.example.demo.model.HousePriceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

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

    @PostMapping
    public ResponseEntity<HousePrice> AddHousePrice(@RequestBody HousePrice housePrice) throws URISyntaxException {
        HousePrice newHousePrice = housePriceRepository.save(housePrice);
        return ResponseEntity.created(new URI("/housePrices/" + newHousePrice.getId())).body(newHousePrice);
    }

    @PutMapping("/{id}")
    public ResponseEntity UpdateHousePrice(@PathVariable Integer id, @RequestBody HousePrice housePrice) {
        HousePrice currentHousePrice = housePriceRepository.findById(id).orElse(null);
        currentHousePrice.setPrice(housePrice.getPrice());
        currentHousePrice.setDate(housePrice.getDate());
        currentHousePrice = housePriceRepository.save(currentHousePrice);

        return ResponseEntity.ok().body(currentHousePrice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteHousePrice(@PathVariable Integer id) {
        housePriceRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
