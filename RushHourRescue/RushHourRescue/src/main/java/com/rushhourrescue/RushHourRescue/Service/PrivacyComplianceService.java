package com.rushhourrescue.RushHourRescue.Service;

import com.rushhourrescue.RushHourRescue.Repository.UserLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PrivacyComplianceService {
    @Autowired
    private UserLocationRepository repository;

    @Scheduled
    public void deleteTemporaryLocationLogs(Long id) {
        LocalDateTime cutoffTime = LocalDateTime.now().minusMinutes(60);
        repository.deleteByIdAndTimestampBefore(id, cutoffTime);
        System.out.println("Deleted temporary location logs before " + cutoffTime);
    }
    public void deleteTemporaryLocationLogsForUser(Long userId){
        repository.deleteById(userId);
    }

}
