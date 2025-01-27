package com.rushhourrescue.RushHourRescue.Repository;

import com.rushhourrescue.RushHourRescue.Entity.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    void deleteByIdAndTimestampBefore(LocalDateTime cutoffTime);
//    void deleteByUserIdAndIsTemporaryTrue(Long userId);
}
