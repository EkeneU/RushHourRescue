package com.rushhourrescue.RushHourRescue.Repository;

import com.rushhourrescue.RushHourRescue.Entity.TrafficZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficZoneRepository extends JpaRepository<TrafficZone, Long> {
    TrafficZone findTopByOrderByIdDesc();
}
