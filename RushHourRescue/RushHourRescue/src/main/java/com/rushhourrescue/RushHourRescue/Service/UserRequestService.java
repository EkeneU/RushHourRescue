package com.rushhourrescue.RushHourRescue.Service;

import com.rushhourrescue.RushHourRescue.Entity.UserRequest;
import com.rushhourrescue.RushHourRescue.Repository.UserRequestRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserRequestService {
    @Autowired
    private UserRequestRepository repository;
    @Scheduled(fixedRate = 5000)
    public void processRequests() {
        List<UserRequest> requests = getPrioritizedRequests();
        for (UserRequest request : requests) {
            if (request.getRequest_id() != null) {
                System.out.println("Processing request with ID " + request.getRequest_id() +
                        " and request time " + request.getRequestTime());
            }
            else {
                System.out.println("Apologies but there are no valid user requests at this time");
            }

        }
    }
    @Transactional
    public UserRequest saveRequest(UserRequest request){
        if (request!=null){
            return repository.save(request);
        }else {
            return null;
        }

    }

    public List<UserRequest> getPrioritizedRequests() {
        return repository.findAllByOrderByRequestTimeAsc();
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
        return repository.findById(request_id).orElse(null);
    }
}
