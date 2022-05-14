package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false, length = 100)
    private String name;

    @Column(name="description", nullable = false, length = 300)
    private String description;

    @Column(name="price", nullable = false)
    private int price;

    @Column(name="creationTime", nullable = false)
    private LocalDateTime creationTime;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="deviceType", nullable = false)
    private DeviceType deviceType;


}
