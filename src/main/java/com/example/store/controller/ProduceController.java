package com.example.store.controller;

import com.example.store.model.Produce;
import com.example.store.service.ProduceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@RestController
public class ProduceController {
    @Autowired
    ProduceService produceService;

    @GetMapping("/produce")
    Collection<Produce> getAllProduce() {
        return produceService.getProduce();
    }

    @GetMapping("/produce/{id}")
    public ResponseEntity<?> getProduceById(@PathVariable("id") String id) {
        return produceService.getProduceById(id);
    }

    @PutMapping("/produce")
    public void updateProduce(@RequestBody Produce produce) {
        produceService.updateProduce(produce);

    }

    @PostMapping("/produce")
    public void addProduce(@RequestBody Produce produce) {
        produceService.addProduce(produce);
    }

    @DeleteMapping("/produce/{id}")
    public void deleteProduce(@PathVariable String id) {
        produceService.deleteProduceById(id);
    }

}
