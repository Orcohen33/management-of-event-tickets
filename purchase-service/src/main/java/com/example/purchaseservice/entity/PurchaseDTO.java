package com.example.purchaseservice.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@Builder
public class PurchaseDTO {

    private Long id;
    private Long userId;
    private Double totalAmount;
    private LocalDateTime purchaseTime;
    private List<Long> ticketIds;

}
