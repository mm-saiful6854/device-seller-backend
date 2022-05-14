package com.example.demo.controller;


import com.example.demo.model.Device;
import com.example.demo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("api/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    @PostMapping
    public ResponseEntity<?> saveDevice(@RequestBody Device device)
    {
        System.out.println("save Device");
        return new ResponseEntity<>(deviceService.saveDevice(device), HttpStatus.CREATED);
    }

    @DeleteMapping("{deviceId}")
    public ResponseEntity<?> deleteDevice(@PathVariable Long deviceId)
    {
        deviceService.deleteDevice(deviceId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllDevice(){
        return new ResponseEntity<>(deviceService.findAllDevice(), HttpStatus.OK);
    }

}


