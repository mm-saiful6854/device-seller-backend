package com.example.demo.service;

import com.example.demo.model.Device;

import java.util.List;

public interface DeviceService {
    Device saveDevice(Device device);

    List<Device> findAllDevice();
    void deleteDevice(Long id);
}
