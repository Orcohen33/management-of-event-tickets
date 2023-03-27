package com.example.purchaseservice.service;

import com.example.purchaseservice.entity.Purchase;
import com.example.purchaseservice.entity.PurchaseDTO;
import com.example.purchaseservice.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

//    CRUD Operations
    public PurchaseDTO createPurchase(PurchaseDTO purchase) {

        Purchase savedPurchase = mapToEntity(purchase);
        return mapToDTO(savedPurchase);
    }






    private PurchaseDTO mapToDTO(Purchase savedPurchase) {
        return PurchaseDTO.builder()
                .build();
    }

    private Purchase mapToEntity(PurchaseDTO purchase) {
        return Purchase.builder()
                .build();
    }
}
