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

    private boolean isWithinEligibleZone(UserLocation location) {
        return location.getLatitude() >= MIN_LAT && location.getLatitude() <= MAX_LAT
                && location.getLongitude() >= MIN_LON && location.getLongitude() <= MAX_LON;
    }
}
