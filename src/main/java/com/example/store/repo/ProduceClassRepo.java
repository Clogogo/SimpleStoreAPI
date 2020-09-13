package com.example.store.repo;

import com.example.store.model.Produce;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProduceClassRepo extends CrudRepository<Produce, String> {

    Optional<Produce> findById(String productId);

    void deleteById(String productId);

}
