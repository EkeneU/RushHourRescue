package com.rushhourrescue.RushHourRescue.Service;
import com.rushhourrescue.RushHourRescue.Entity.DeliveryStatus;
import com.rushhourrescue.RushHourRescue.Entity.Rider;
import com.rushhourrescue.RushHourRescue.Entity.UserRequest;
import com.rushhourrescue.RushHourRescue.Repository.DeliveryStatusRepository;
import com.rushhourrescue.RushHourRescue.Repository.RiderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    private RiderRepository riderRepository;
    @Autowired
    private DeliveryStatusRepository repository;
    @Autowired
    private UserRequestService requestService;

    @Transactional
    public void startDelivery(int delivery_id, UserRequest request) {
        Optional<DeliveryStatus> activeDelivery = repository.findById(delivery_id);
        List<UserRequest> prioritizedRequests = requestService.getPrioritizedRequests();
        if (activeDelivery.isPresent()) {
            DeliveryStatus deliveryStatus = activeDelivery.get();
            deliveryStatus.setSuccessful(false);
            System.out.println("An active delivery already exists for user with ID " + delivery_id);
            return;
        }

        for (UserRequest userRequest : prioritizedRequests){
            if (request.getRequest_id().equals(userRequest.getRequest_id())) {
                assignNextAvailableRiderToNextRequest(request);
                DeliveryStatus newDelivery = new DeliveryStatus(delivery_id, false, LocalDateTime.now(), request);
                repository.save(newDelivery);
            }
        }

    }

    public void assignNextAvailableRiderToNextRequest(UserRequest nextRequest) {
        System.out.println("📌 Received nextRequest: " + nextRequest);
        System.out.println("📌 nextRequest ID BEFORE fetching: " + nextRequest.getRequest_id());

        // Ensure the request is fetched from the database
        UserRequest request = requestService.getUserRequest(nextRequest.getRequest_id());

        System.out.println("📌 request AFTER fetching: " + request);
        System.out.println("📌 request ID AFTER fetching: " + (request != null ? request.getRequest_id() : "NULL"));

        if (request == null) {
            System.out.println("⚠️ The request is NULL, meaning it doesn't exist in the database.");
            return;
        }
        Rider availableRider = riderRepository.findByStatus("AVAILABLE").stream().findFirst().orElse(null);
        if (availableRider != null) {
            availableRider.setStatus("BUSY");
            riderRepository.save(availableRider);

            request.setStatus(UserRequest.RequestStatus.ASSIGNED);
            requestService.updateRequestStatus(request.getRequest_id(), UserRequest.RequestStatus.ASSIGNED);
            System.out.println("✅ Assigned Rider ID " + availableRider.getRider_id() + " to request ID " + request.getRequest_id());
        } else {
            System.out.println("❌ No available riders found.");
        }
//            if (request.getRequest_id().equals(nextRequest.getRequest_id()) && availableRider != null) {
//                availableRider.setStatus("BUSY");
//
//                riderRepository.save(availableRider);
//                nextRequest.setStatus(UserRequest.RequestStatus.ASSIGNED);
//                requestService.updateRequestStatus(nextRequest.getRequest_id(), UserRequest.RequestStatus.ASSIGNED);
//                System.out.println("Assigned Rider ID " + availableRider.getRider_id() + " to request ID" + nextRequest.getRequest_id());
//
//                //TODO: Find out why nextRequest.getRequest_id() is null
//            } else if (request.getRequest_id().equals(nextRequest.getRequest_id())) {
//                nextRequest.setStatus(UserRequest.RequestStatus.PENDING);
//                requestService.updateRequestStatus(nextRequest.getRequest_id(), UserRequest.RequestStatus.PENDING);
//                System.out.println("Sorry, there no currently available riders. Please be patient");
//            } else {
//                System.out.println("Sorry, there are currently neither no available riders nor available requests.");
//        }


    }
    @Transactional
    public void completeDelivery(int delivery_id) {
        Optional<DeliveryStatus> activeDelivery = repository.findById(delivery_id);
        if (activeDelivery.isPresent()) {
            DeliveryStatus status = activeDelivery.get();
            status.setSuccessful(true);
            status.setCompletionTime(LocalDateTime.now());
            repository.save(status);
        }
    }
}
