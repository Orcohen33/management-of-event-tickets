package com.orcohen.eventsservice.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class LocationResponse {

    private Long id;

    private String name;

    private Integer capacity;

    private String address;

    private String city;
}
