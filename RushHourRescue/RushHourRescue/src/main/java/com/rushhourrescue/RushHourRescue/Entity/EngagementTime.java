package com.rushhourrescue.RushHourRescue.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngagementTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int engagement_id;
    private LocalDateTime sessionStart;
    private LocalDateTime sessionEnd;
    private boolean isSessionActive;

    @OneToOne(mappedBy = "engagementTime", cascade = CascadeType.ALL)
    private UserRequest userRequest;
}
