package com.rushhourrescue.RushHourRescue.Controller;

import com.rushhourrescue.RushHourRescue.Entity.UserRequest;
import com.rushhourrescue.RushHourRescue.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dispatch")
public class DispatchController {
    @Autowired
    private DeliveryService assignmentService;

    @PostMapping("/assign")
    public ResponseEntity<String> assignNextRequest(@RequestBody UserRequest request) {
        assignmentService.assignNextAvailableRiderToNextRequest(request);
        return ResponseEntity.ok("Assignment processed");
    }
}
