package com.orcohen.locationservice.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class LocationRequest {

    private String name;

    private Integer capacity;

    private String address;

    private String city;
}
