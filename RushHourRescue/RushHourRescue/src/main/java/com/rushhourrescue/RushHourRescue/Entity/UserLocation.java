package com.rushhourrescue.RushHourRescue.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private Double latitude;
    private Double longitude;
    private Double speed;
    private String zoneId;
    private LocalDateTime timestamp;
    @OneToOne(mappedBy = "userLocation", cascade = CascadeType.ALL)
    private UserRequest request;

}
