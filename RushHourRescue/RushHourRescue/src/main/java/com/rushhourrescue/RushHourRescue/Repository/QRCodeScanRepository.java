package com.rushhourrescue.RushHourRescue.Repository;

import com.rushhourrescue.RushHourRescue.Entity.QRCodeScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QRCodeScanRepository extends JpaRepository<QRCodeScan, Integer> {
}
