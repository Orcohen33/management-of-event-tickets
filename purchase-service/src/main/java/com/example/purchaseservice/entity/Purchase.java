package com.example.purchaseservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long userId;

    LocalDateTime purchaseTime;

    Double totalAmount;

    @ElementCollection
    List<Long> ticketIds;

    // Additional fields and methods can be added as needed.

}
