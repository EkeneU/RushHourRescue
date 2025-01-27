package com.rushhourrescue.RushHourRescue.Repository;

import com.rushhourrescue.RushHourRescue.Entity.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryStatusRepository extends JpaRepository<DeliveryStatus, Integer> {
}
