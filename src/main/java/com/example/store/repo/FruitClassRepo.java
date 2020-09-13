package com.example.store.repo;

import com.example.store.model.Fruits;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface FruitClassRepo extends CrudRepository<Fruits, String> {

    Optional<Fruits> findById(String Id);

    void deleteById(String Id);

    List <Fruits> findByProduceId(String produceId);
}
