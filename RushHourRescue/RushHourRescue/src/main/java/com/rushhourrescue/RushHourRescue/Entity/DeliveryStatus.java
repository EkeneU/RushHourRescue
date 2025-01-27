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
public class DeliveryStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int delivery_id;
    private boolean isSuccessful;
    private LocalDateTime completionTime;
    @OneToOne(mappedBy = "deliveryStatus", cascade = CascadeType.ALL)
    private UserRequest request;



}
