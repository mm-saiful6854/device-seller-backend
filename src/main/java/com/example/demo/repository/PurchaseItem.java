package com.example.demo.repository;

import com.example.demo.model.Color;
import com.example.demo.model.DeviceType;

import java.time.LocalDateTime;

public interface PurchaseItem {

    String getName();
    DeviceType getType();
    Color getColor();
    double getPrice();
    LocalDateTime getPurchaseTime();
}
