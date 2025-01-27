package com.rushhourrescue.RushHourRescue.Repository;

import com.rushhourrescue.RushHourRescue.Entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Integer> {
    List<Rider> findByStatus(String status);
}
