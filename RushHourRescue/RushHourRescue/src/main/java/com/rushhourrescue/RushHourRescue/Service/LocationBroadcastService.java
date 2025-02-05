package com.rushhourrescue.RushHourRescue.Service;

import com.rushhourrescue.RushHourRescue.Entity.UserLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class LocationBroadcastService {
    //TODO: GO THROUGH THIS SERVICE CAREFULLY
    private static Double MAX_LON;
    private static Double MIN_LON;
    private static Double MAX_LAT;
    private static Double MIN_LAT;
    @Autowired
    private SimpMessagingTemplate template;

    public void broadcastLocationUpdate(UserLocation location) {
        if (isWithinEligibleZone(location)) {
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
