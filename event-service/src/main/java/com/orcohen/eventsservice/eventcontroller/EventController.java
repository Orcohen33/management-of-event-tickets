package com.orcohen.eventsservice.eventcontroller;

import com.orcohen.eventsservice.dto.request.EventRequest;
import com.orcohen.eventsservice.dto.response.EventLocationResponse;
import com.orcohen.eventsservice.dto.response.EventResponse;
import com.orcohen.eventsservice.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    public final EventService eventService;

    @GetMapping("/test")
    public String test() {
        return "test";
    }
    @GetMapping
    public List<EventResponse> getEvents() {
        return eventService.findAllEvents();
    }

    @GetMapping("/{id}")
    public EventLocationResponse getEventById(@PathVariable Long id) {
        return eventService.findEventById(id);
    }

    @PostMapping
    public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest eventRequest) {
        try{
            final var event = eventService.createEvent(eventRequest);
            URI location = URI.create(String.format("/api/v1/events/%s", event.getId()));
            return ResponseEntity.created(location).body(event);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public EventResponse updateEvent(@PathVariable Long id, @RequestBody EventRequest eventRequest) {
        return eventService.updateEvent(id, eventRequest);
    }

}
