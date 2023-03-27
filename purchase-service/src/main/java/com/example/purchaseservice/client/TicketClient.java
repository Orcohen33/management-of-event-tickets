package com.example.purchaseservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ticket-service")
public interface TicketClient {

    @GetMapping("/api/v1/tickets/test")
    String getTickets();
}
