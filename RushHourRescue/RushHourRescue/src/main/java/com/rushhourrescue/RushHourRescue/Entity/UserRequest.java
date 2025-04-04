package com.rushhourrescue.RushHourRescue.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer request_id;
    private String first_name;
    private String last_name;
    private int age;
    private String sex;
    private String email;
    private String user_password;
    private LocalDateTime requestTime;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private UserLocation userLocation;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "scan_id")
    private QRCodeScan qrCodeScan;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private DeliveryStatus deliveryStatus;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engagement_id")
    private EngagementTime engagementTime;


    public enum RequestStatus {
        PENDING,
        IN_PROGRESS,
        ASSIGNED,
        PROCESSED
    }
}
