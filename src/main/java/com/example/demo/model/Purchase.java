package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name="purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="userID", nullable = false)
    private long userID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userID", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;


    @Column(name="deviceID", nullable = false)
    private long deviceID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="deviceID", referencedColumnName = "id", insertable = false, updatable = false)
    private Device device;

    @Column(name="price", nullable = false)
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name="deviceColor")
    private Color color;

    @Column(name="purchaseTime")
    private LocalDateTime datetime;

}
