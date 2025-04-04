package com.rushhourrescue.RushHourRescue.Controller;

import com.rushhourrescue.RushHourRescue.Entity.UserRequest;
import com.rushhourrescue.RushHourRescue.Producer.DeliveryRequestProducer;
import com.rushhourrescue.RushHourRescue.Service.DeliveryService;
import com.rushhourrescue.RushHourRescue.Service.UserRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dispatch")
public class DispatchController {
    @Autowired
    private DeliveryService assignmentService;

    @Autowired
    private UserRequestService requestService;

    @Autowired
    private DeliveryRequestProducer requestProducer;


    @PutMapping("/assign")
    public ResponseEntity<String> assignNextRequest(@RequestBody UserRequest request) {
        assignmentService.assignNextAvailableRiderToNextRequest(request);
        return ResponseEntity.ok("Assignment processed");
    }

    @PostMapping("/create")
    public ResponseEntity<UserRequest> createRequest(@RequestBody UserRequest request) {
         requestProducer.sendRequest(request);
         requestService.saveRequest(request);
        return ResponseEntity.ok(request);
    }


}
