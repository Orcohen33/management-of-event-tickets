package com.orcohen.eventsservice.clients;

import com.orcohen.eventsservice.dto.response.LocationResponse;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "LOCATION-SERVICE")
@LoadBalancerClient(name = "LOCATION-SERVICE")
public interface LocationServiceApi {

    @GetMapping("/api/v1/locations/{id}")
    LocationResponse getLocationById(@PathVariable Long id);
}
