package com.rushhourrescue.RushHourRescue.Logging;

import com.rushhourrescue.RushHourRescue.Entity.EngagementTime;
import com.rushhourrescue.RushHourRescue.Entity.UserLocation;
import com.rushhourrescue.RushHourRescue.Entity.UserRequest;
import com.rushhourrescue.RushHourRescue.Service.LoggingService;
import com.rushhourrescue.RushHourRescue.Service.QRCodeScanService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class DataLogging {
    @Autowired
    private LoggingService loggingService;
    @Autowired
    private QRCodeScanService scanService;

    @Pointcut("execution(*com.rushhourrescue.RushHourRescue.Service.QRCodeScanService.numberOfQRCodeScans())")
    public void qrCodeScans() {
    }
    @Pointcut("execution(*com.rushhourrescue.RushHourRescue.Service.UserLocationService.updateLocation(..))")
    public void locationUpdate() {

    }
    @Pointcut("execution(*com.rushhourrescue.RushHourRescue.Service.EngagementTimeService.startSession(..))")
    public void sessionStart() {

    }
    @Pointcut("execution(*com.rushhourrescue.RushHourRescue.Service.EngagementTimeService.endSession(..))")
    public void sessionEnd() {

    }
    @Pointcut("execution(*com.rushhourrescue.RushHourRescue.Service.DeliveryService.completeDelivery(..)")
    public void deliveryComplete() {

    }
    @After("qrCodeScans()")
    public void logQRCodeScanNumber(JoinPoint joinPoint){
        Integer userId = (Integer) joinPoint.getArgs()[0];
        loggingService.logQRCodeScan(userId);
    }
    @After("locationUpdate()")
    public void logUserLocation(JoinPoint joinpoint) {
        UserLocation location = (UserLocation) joinpoint.getArgs()[0];
        loggingService.logUserLocation(location);
    }
    @After("sessionStart()")
    public void logSessionStart(JoinPoint joinPoint) {
        Integer userid = (Integer) joinPoint.getArgs()[0];
        EngagementTime engagementTime = (EngagementTime) joinPoint.getArgs()[1];
        loggingService.logEngagementTime(userid, engagementTime);
    }
    @After("sessionEnd()")
    public void logSessionEnd(JoinPoint joinPoint) {
        Integer userId = (Integer) joinPoint.getArgs()[0];
        Long sessionEnd = (Long) joinPoint.getArgs()[1];
        loggingService.updateEngagementEndTime(userId, sessionEnd);
    }
    @After("deliveryComplete()")
    public void logDeliveryComplete(JoinPoint joinPoint) {
        Integer deliveryId = (Integer) joinPoint.getArgs()[0];
        Long userId = (Long) joinPoint.getArgs()[1];
        boolean success = (boolean) joinPoint.getArgs()[2];
        loggingService.logDeliveryStatus(deliveryId, userId, success);

    }
}
