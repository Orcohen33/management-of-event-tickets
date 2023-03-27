package com.orcohen.eventsservice.dto.response;

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
public class EventLocationResponse {
    Long id;

    private String name;

    private String description;

    private double ticketPrice;

    private Long locationId;

    private Integer capacity;
    private LocalDate date;

    private LocationResponse location;
}
