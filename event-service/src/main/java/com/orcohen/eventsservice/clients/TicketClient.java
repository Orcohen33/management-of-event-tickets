package com.orcohen.eventsservice.clients;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "LOCATION-SERVICE")
//@LoadBalancerClient(name = "LOCATION-SERVICE")
public interface TicketClient {

//    @GetMapping("/api/v1/locations")
//    String getLocations();

}
