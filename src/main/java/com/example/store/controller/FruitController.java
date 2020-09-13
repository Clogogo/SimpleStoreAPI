package com.example.store.controller;


import com.example.store.model.Fruits;
import com.example.store.model.Produce;
import com.example.store.service.FruitService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@RestController
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping("/produce/{productId}/fruits")
    List<Fruits> getAllFruits(@PathVariable("productId") String productId) {
        return fruitService.getAllFruits(productId);
    }

    @GetMapping("/produce/{produceId}/fruits/{Id}")
    public Optional<Fruits> getFruitsById(@PathVariable String Id) {
        return fruitService.getFruitsById(Id);
    }

    @PostMapping("/produce/{productid}/fruits")
    public void addFruit(@RequestBody Fruits fruits,@PathVariable("productid") String productid) {
        fruits.setProduce(new Produce(productid,""));
        fruitService.addFruits(fruits);

    }

    @PutMapping("/produce/{prodctid}/fruits")
    public void updateFruit(@RequestBody Fruits fruits) {
        fruitService.updateFruits(fruits);
    }

    @DeleteMapping("/produce/{prodctid}/delete/{id}")
    public void deleteFruit(@PathVariable String id) {
        fruitService.deleteFruits(id);
    }

}
