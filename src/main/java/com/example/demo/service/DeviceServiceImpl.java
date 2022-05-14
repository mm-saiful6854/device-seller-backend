package com.example.demo.service;

import com.example.demo.model.Device;
import com.example.demo.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService{

    private final DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device saveDevice(Device device)
    {
        device.setCreationTime(LocalDateTime.now());

        return deviceRepository.save(device);
    }

    public void deleteByID(Long Id)
    {
        deviceRepository.deleteById(Id);
    }

    @Override
    public List<Device> findAllDevice()
    {
        return deviceRepository.findAll();
    }

    @Override
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
}
