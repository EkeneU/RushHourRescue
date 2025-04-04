package com.rushhourrescue.RushHourRescue.Repository;

import com.rushhourrescue.RushHourRescue.Entity.EngagementTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EngagementTimeRepository extends JpaRepository<EngagementTime, Integer> {

//    EngagementTime findTopByUserIdAndSessionEndIsNullOrderBySessionStartDesc(Long userId);
}
