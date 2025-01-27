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
public class QRCodeScan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scan_id;
    private LocalDateTime scanTime;
    @OneToOne(mappedBy = "qrCodeScan", cascade = CascadeType.ALL)
    private UserRequest userRequest;

}
