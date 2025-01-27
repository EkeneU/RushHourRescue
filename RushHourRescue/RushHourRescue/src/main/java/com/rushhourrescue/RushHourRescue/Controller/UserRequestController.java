package com.rushhourrescue.RushHourRescue.Controller;

import com.rushhourrescue.RushHourRescue.Entity.UserLocation;
import com.rushhourrescue.RushHourRescue.Entity.UserRequest;
import com.rushhourrescue.RushHourRescue.Service.LocationBroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class UserRequestController {
    @Autowired
    private LocationBroadcastService service;
    @MessageMapping("/user.addUser")
    @SendTo("/topic/public")
    public UserRequest addUser(@Payload UserRequest userRequest, SimpMessageHeaderAccessor accessor) {
        Objects.requireNonNull(accessor.getSessionAttributes()).put("username", userRequest);
        return userRequest;
    }

    @MessageMapping("/user.sendLocation")
    @SendTo("/topic/location")
    public void sendLocation(@Payload UserLocation location) {
         service.broadcastLocationUpdate(location);
    }
}
