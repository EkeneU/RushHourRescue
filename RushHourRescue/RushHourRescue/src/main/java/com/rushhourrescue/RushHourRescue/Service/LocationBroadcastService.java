package com.rushhourrescue.RushHourRescue.Service;

import com.rushhourrescue.RushHourRescue.Entity.TrafficZone;
import com.rushhourrescue.RushHourRescue.Entity.UserLocation;
import com.rushhourrescue.RushHourRescue.Repository.TrafficZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class LocationBroadcastService {
    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private TrafficZoneRepository zoneRepository;

    public void broadcastLocationUpdate(UserLocation location) {
        if (isWithinEligibleZone(location.getLatitude(), location.getLongitude())) {
            template.convertAndSend("/topic/locations", location);
        }
    }

    private boolean isWithinEligibleZone(double latitude, double longitude) {
        TrafficZone trafficZone = zoneRepository.findTopByOrderByIdDesc();
        if (trafficZone == null) {
            throw new IllegalStateException("Zone boundaries are unavailable");
        }

        return latitude >= trafficZone.getMinLat() && latitude <= trafficZone.getMaxLat() &&
                longitude >= trafficZone.getMinLon() && longitude <= trafficZone.getMaxLon();
    }
}
