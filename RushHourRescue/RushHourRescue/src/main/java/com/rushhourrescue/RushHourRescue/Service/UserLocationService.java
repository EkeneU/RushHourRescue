package com.rushhourrescue.RushHourRescue.Service;

import com.rushhourrescue.RushHourRescue.Entity.UserLocation;
import com.rushhourrescue.RushHourRescue.Repository.UserLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLocationService {
    @Autowired
    private UserLocationRepository repository;

    @Autowired
    private LocationBroadcastService broadcastService;

    public UserLocation updateLocation (UserLocation location) {
        broadcastService.broadcastLocationUpdate(location);
        return repository.save(location);


    }
}
