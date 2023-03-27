package com.orcohen.ticketservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

        @RequestMapping("/test")
        public String test() {
            return "Ticket Service is working";
        }

}
