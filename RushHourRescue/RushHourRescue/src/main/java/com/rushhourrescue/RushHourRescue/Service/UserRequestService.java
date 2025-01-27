package com.rushhourrescue.RushHourRescue.Service;

import com.rushhourrescue.RushHourRescue.Entity.UserRequest;
import com.rushhourrescue.RushHourRescue.Repository.UserRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRequestService {
    @Autowired
    private UserRequestRepository repository;


    @Scheduled(fixedRate = 5000)
    public void processRequests() {
        List<UserRequest> requests = getPrioritizedRequests();
        for (UserRequest request : requests) {
            System.out.println("Processing request with ID " + request.getRequest_id() +
                    " and request time " + request.getRequest_time());
        }
    }

    public List<UserRequest> getPrioritizedRequests() {
        return repository.findAllByRequestTimeAsc();
    }

    public void updateRequestStatus(Integer requestId, UserRequest.RequestStatus newStatus) {
        Optional<UserRequest> optionalRequest = repository.findById(requestId);
        if (optionalRequest.isPresent()) {
            UserRequest request = optionalRequest.get();
            request.setStatus(newStatus);
            repository.save(request);
        }
        else {
            System.out.println("Request with ID " + requestId + " not found");
        }
    }

    public UserRequest getUserRequest(int request_id) {
        List<UserRequest> requests = getPrioritizedRequests();

        return requests.get(request_id);
    }
}
