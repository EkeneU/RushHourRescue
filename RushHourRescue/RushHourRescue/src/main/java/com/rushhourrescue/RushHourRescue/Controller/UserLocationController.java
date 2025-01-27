package com.rushhourrescue.RushHourRescue.Controller;

import com.rushhourrescue.RushHourRescue.Entity.UserLocation;
import com.rushhourrescue.RushHourRescue.Service.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserLocationController {
    @Autowired
    private UserLocationService service;
    @PutMapping("/location")
    public UserLocation updateUserLocation(@RequestBody UserLocation location) {
        return service.updateLocation(location);
    }

}
