package com.rushhourrescue.RushHourRescue.Service;

import com.rushhourrescue.RushHourRescue.Entity.EngagementTime;
import com.rushhourrescue.RushHourRescue.Entity.UserRequest;
import com.rushhourrescue.RushHourRescue.Repository.EngagementTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
public class EngagementTimeService {
    @Autowired
    private EngagementTimeRepository repository;

    public void startSession(int engagement_id, UserRequest request) {
        Optional<EngagementTime> result = repository.findById(engagement_id);
        if (result.isPresent()) {
            EngagementTime engagementTime = result.get();
            engagementTime.setSessionActive(true);
            System.out.println("An active session already exists for the user with ID" + engagement_id);
            return;
        }
        EngagementTime newSession = new EngagementTime(engagement_id, LocalDateTime.now(), null,
                true, request);

        repository.save(newSession);
        System.out.println("Session started for user with ID" + request.getRequest_id());
    }

    public void endSession(int engagement_id, UserRequest request) {
        Optional<EngagementTime> activeSession = repository.findById(engagement_id);
        if (activeSession.isPresent()){
            EngagementTime session = activeSession.get();
            session.setSessionEnd(LocalDateTime.now());
            session.setSessionActive(false);
            repository.save(session);

            System.out.println("Session ended for User with ID " + request.getRequest_id());
            return;
        }
            System.out.println("No active session found for user with ID" + request.getRequest_id());
    }

    public void updateEngagementEndTime(int userId, Long sessionEnd) {
        //TODO: Alternatively, make the custom method in the repository interface return optional

        // Find the latest engagement time record for the user where sessionEnd is null
//        EngagementTime engagement = repository.findTopByUserIdAndSessionEndIsNullOrderBySessionStartDesc(userId);
//        if (engagement != null) {
//            engagement.setSessionEnd(LocalDateTime.ofEpochSecond(sessionEnd / 1000, 0, java.time.ZoneOffset.UTC));
//            repository.save(engagement);
//        }
        Optional<EngagementTime> result = repository.findById(userId);
        if (result.isPresent()){
            EngagementTime time = result.get();
            if (time.getSessionEnd()==null) {
                time.setSessionEnd(LocalDateTime.ofEpochSecond(sessionEnd/1000, 0, ZoneOffset.UTC));
                repository.save(time);
            }
        }

    }
}
