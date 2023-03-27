package com.orcohen.locationservice.controller;

import com.orcohen.locationservice.dto.request.LocationRequest;
import com.orcohen.locationservice.dto.response.LocationResponse;
import com.orcohen.locationservice.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/{id}")
    public LocationResponse getLocations(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }
}
