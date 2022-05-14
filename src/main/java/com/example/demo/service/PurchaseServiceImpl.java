package com.example.demo.service;

import com.example.demo.model.Purchase;
import com.example.demo.repository.PurchaseItem;
import com.example.demo.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseServiceImpl {

    @Autowired
    private PurchaseRepository repo;


    public Purchase savePurchase(Purchase purchase)
    {
        purchase.setDatetime(LocalDateTime.now());

        return repo.save(purchase);
    }

    public List<PurchaseItem> findPurchaseByUserId(long userId)
    {
        return repo.findAllPurchaseByUser(userId);
    }

}
