package com.rushhourrescue.RushHourRescue.Service;

import com.rushhourrescue.RushHourRescue.Entity.QRCodeScan;
import com.rushhourrescue.RushHourRescue.Repository.QRCodeScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QRCodeScanService {

    @Autowired
    private QRCodeScanRepository scanRepository;


    public int numberOfQRCodeScans() {
        List<QRCodeScan> scans = scanRepository.findAll();
        int scanId = 0;
        int totalNumberOfScans = 0;
        for (QRCodeScan scan : scans) {
            scanId = scan.getScan_id();
            totalNumberOfScans++;
            System.out.println(scan);

        }
        System.out.println("Total number of scans " + totalNumberOfScans);
        return scanId;
    }
}
