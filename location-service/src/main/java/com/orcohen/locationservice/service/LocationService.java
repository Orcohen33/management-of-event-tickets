package com.orcohen.locationservice.service;

import com.orcohen.locationservice.dto.request.LocationRequest;
import com.orcohen.locationservice.dto.response.LocationResponse;
import com.orcohen.locationservice.entity.Location;
import com.orcohen.locationservice.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationResponse getLocationById(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new RuntimeException("Location not found"));
        return mapToDTO(location);
    }





    private LocationResponse mapToDTO(Location location) {
        return LocationResponse.builder()
                .id(location.getId())
                .name(location.getName())
                .capacity(location.getCapacity())
                .address(location.getAddress())
                .city(location.getCity())
                .build();
    }

    private Location mapToEntity(LocationRequest locationRequest) {
        return Location.builder()
//                .id(locationRequest.getId())
                .name(locationRequest.getName())
                .capacity(locationRequest.getCapacity())
                .address(locationRequest.getAddress())
                .city(locationRequest.getCity())
                .build();
    }

}
