package com.example.demo.controller;

import com.example.demo.model.Purchase;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.security.UserPrincipal;
import com.example.demo.service.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseServiceImpl purchaseService;

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase)
    {
        return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllPurchase(@AuthenticationPrincipal UserPrincipal principal)
    {
        /*3 ways:
            1. SecurityContextHolder.getContext().getAuthentication().getPrincipal()
            2. HttpServletRequest.getUserPrincipal()
            3. @AuthenticationPrincipal principal*/

        return ResponseEntity.ok(purchaseService.findPurchaseByUserId(principal.getId()));

    }
}
