package com.example.store.service;


import com.example.store.model.Fruits;
import com.example.store.model.Produce;
import com.example.store.repo.FruitClassRepo;
import com.example.store.repo.ProduceClassRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class FruitService {

    @Autowired
    FruitClassRepo fruitClassRepo;

    ProduceClassRepo produceClassRepo;


    //Get all fruits
    public List<Fruits> getAllFruits(String productId) {
        return new ArrayList<>(fruitClassRepo.findByProduceId(productId));
    }

    public Optional<Fruits> getFruitsById(String Id) {
        return fruitClassRepo.findById(Id);
    }

    //Add fruits by fruits paramater
    public void addFruits(Fruits name) {

        fruitClassRepo.save(name);
    }


    //Delete fruits by ID
    public void deleteFruits(String id) {
        fruitClassRepo.deleteById(id);
    }


    public void updateFruits(Fruits fruits) {
        if (fruitClassRepo.findById(fruits.getId()).isPresent()) {
            fruitClassRepo.save(fruits);
        }
    }
}
