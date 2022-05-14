package com.example.demo.repository;

import com.example.demo.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

    @Query("select d.name as name, d.deviceType as type, " +
            "p.price as price, p.color as color, p.datetime as purchaseTime" +
            " from Purchase as p left join Device as d on p.deviceID = d.id where p.userID = :userID")
    List<PurchaseItem> findAllPurchaseByUser(@Param("userID") long userID);
}
