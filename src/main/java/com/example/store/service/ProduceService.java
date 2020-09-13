package com.example.store.service;

import com.example.store.model.Produce;
import com.example.store.repo.ProduceClassRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class ProduceService {

    @Autowired
    ProduceClassRepo produceClassRepo;

    public List<Produce> getProduce() {
        List<Produce> produce = new ArrayList<>();
        produceClassRepo.findAll().forEach(produce ::add);
        return produce;
    }

   public ResponseEntity<?> getProduceById(String Id) {
        Optional<Produce> produce = produceClassRepo.findById(Id);
        return produce.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    public void addProduce(Produce produce) {
        produceClassRepo.save(produce);
    }

    public void updateProduce(Produce produce) {
        if (produceClassRepo.findById(produce.getId()).isPresent()) {
            produceClassRepo.save(produce);
        }
    }

    public void deleteProduceById(String Id) {
        produceClassRepo.deleteById(Id);
    }

}
