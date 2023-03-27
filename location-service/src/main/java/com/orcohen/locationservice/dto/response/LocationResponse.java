package com.orcohen.locationservice.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LocationResponse {

    private Long id;

    private String name;

    private Integer capacity;

    private String address;

    private String city;
}
