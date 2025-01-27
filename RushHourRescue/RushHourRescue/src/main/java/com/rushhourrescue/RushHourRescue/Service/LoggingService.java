package com.rushhourrescue.RushHourRescue.Service;

import com.rushhourrescue.RushHourRescue.Entity.*;
import com.rushhourrescue.RushHourRescue.Repository.DeliveryStatusRepository;
import com.rushhourrescue.RushHourRescue.Repository.QRCodeScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoggingService {
    @Autowired
    private QRCodeScanRepository scanRepository;
    @Autowired
    private DeliveryStatusRepository statusRepository;
    @Autowired
    private UserLocationService locationService;

    @Autowired
    private EngagementTimeService engagementTimeService;

    public void logQRCodeScan(int id) {
        QRCodeScan scan = new QRCodeScan();
        scan.setScan_id(id);
        scan.setScanTime(LocalDateTime.now());

        scanRepository.save(scan);
    }

    public void logUserLocation(UserLocation location){
        locationService.updateLocation(location);
    }
    //TODO: Review this
    public void logEngagementTime(int id, EngagementTime session) {
//        EngagementTime time = new EngagementTime();
//        time.setEngagement_id(id);
//        time.setSessionStart(LocalDateTime.ofEpochSecond(sessionStart/1000, 0, ZoneOffset.UTC));
//
//        if (sessionEnd != null) {
//            time.setSessionEnd(LocalDateTime.ofEpochSecond(sessionEnd/1000, 0, ZoneOffset.UTC));
//        }
//        timeRepository.save(time);

        if (!session.isSessionActive()){
            engagementTimeService.startSession(id, session.getUserRequest());
        }
        else {
            engagementTimeService.endSession(id, session.getUserRequest());
        }


    }

    public void updateEngagementEndTime(int userId, Long sessionEnd) {
        // Find the latest engagement time record for the user where sessionEnd is null
//        EngagementTime engagement = timeRepository.findTopByUserIdAndSessionEndIsNullOrderBySessionStartDesc(userId);
//        if (engagement != null) {
//            engagement.setSessionEnd(LocalDateTime.ofEpochSecond(sessionEnd / 1000, 0, java.time.ZoneOffset.UTC));
//            timeRepository.save(engagement);
//        }

        engagementTimeService.updateEngagementEndTime(userId, sessionEnd);

    }

    //TODO: Review this.
    public void logDeliveryStatus(Integer deliveryId, Long userId, boolean success) {
        DeliveryStatus deliveryStatus = new DeliveryStatus();
        deliveryStatus.setDelivery_id(deliveryId);
        deliveryStatus.setSuccessful(success);
        deliveryStatus.setCompletionTime(LocalDateTime.now());
        statusRepository.save(deliveryStatus);
    }
}
