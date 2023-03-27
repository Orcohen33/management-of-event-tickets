package com.orcohen.eventsservice.dto.request;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
public class EventRequest {
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private Double ticketPrice;
    @NonNull
    private Integer ticketsForSale;
    @NonNull
    private Long locationId;
    @NonNull
    private LocalDate date;
}
