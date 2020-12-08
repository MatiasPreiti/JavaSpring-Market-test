package com.matyspring.market.domain.service;

import com.matyspring.market.domain.Purchase;
import com.matyspring.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
    public class PurchaseService {
        @Autowired
        private PurchaseRepository purchaseRepository;

        public List<Purchase> getAll() {
            return purchaseRepository.getAll();
        }

        public Optional<List<Purchase>> getByClient(String clientId) {
            return purchaseRepository.getByClient(clientId);
        }

        public Purchase save(Purchase purchase) {
            return purchaseRepository.save(purchase);
        }
    }

    @RestController
    @RequestMapping("/purchases")
    public class PurchaseController {
        @Autowired
        private PurchaseService purchaseService;

        @GetMapping("/all")
        public ResponseEntity<List<Purchase>> getAll() {
            return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
        }

        @GetMapping("/client/{idClient}")
        public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient") String clientId) {
            return purchaseService.getByClient(clientId)
                    .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @PostMapping("/save")
        public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
            return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
        }
    }

