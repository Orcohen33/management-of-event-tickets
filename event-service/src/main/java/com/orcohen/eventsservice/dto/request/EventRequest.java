package com.orcohen.eventsservice.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
public class EventRequest {
    private String name;
    private String description;
    private Double ticketPrice;
    private Integer ticketsForSale;
    private Long locationId;
    private LocalDate date;
}
