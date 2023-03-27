package com.orcohen.eventsservice.service;

import com.orcohen.eventsservice.clients.LocationServiceApi;
import com.orcohen.eventsservice.dto.request.EventRequest;
import com.orcohen.eventsservice.dto.response.EventLocationResponse;
import com.orcohen.eventsservice.dto.response.EventResponse;
import com.orcohen.eventsservice.dto.response.LocationResponse;
import com.orcohen.eventsservice.entity.Event;
import com.orcohen.eventsservice.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    @LoadBalanced
    private final LocationServiceApi locationServiceApi;

    //    CRUD operations
    public EventResponse createEvent(EventRequest event) {
        Event savedEvent = mapToEntity(event);
        LocationResponse location = locationServiceApi.getLocationById(event.getLocationId());

        if (savedEvent.getTicketsForSale() > location.getCapacity()) {
            throw new RuntimeException("Not enough tickets available");
        }

        return mapToDTO(eventRepository.save(savedEvent));
    }

    public List<EventResponse> findAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    public EventLocationResponse findEventById(Long id) {
        final var eventLocationResponse = eventRepository.findById(id)
                .map(event ->
                        EventLocationResponse.builder()
                                .id(event.getId())
                                .name(event.getName())
                                .description(event.getDescription())
                                .ticketPrice(event.getTicketPrice())
                                .locationId(event.getLocationId())
                                .capacity(event.getTicketsForSale())
                                .date(event.getDate())
                                .location(locationServiceApi.getLocationById(event.getLocationId()))
                                .build()
                );
     return eventLocationResponse.orElseThrow( () -> new RuntimeException("Event not found"));
    }

    public EventResponse updateEvent(Long id, EventRequest event) {
        Event eventToUpdate = eventRepository.findById(id)
                .orElseThrow();
        eventToUpdate.setName(event.getName());
        eventToUpdate.setDescription(event.getDescription());
        eventToUpdate.setTicketPrice(event.getTicketPrice());
        Event updatedEvent = eventRepository.save(eventToUpdate);
        return mapToDTO(updatedEvent);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    //    Mappers

    public EventResponse mapToDTO(Event event) {
        return EventResponse
                .builder()
                .id(event.getId())
                .name(event.getName())
                .description(event.getDescription())
                .ticketPrice(event.getTicketPrice())
                .ticketsForSale(event.getTicketsForSale())
                .date(event.getDate())
                .build();
    }

    public Event mapToEntity(EventRequest eventRequest) {
        return Event
                .builder()
                .name(eventRequest.getName())
                .description(eventRequest.getDescription())
                .ticketPrice(eventRequest.getTicketPrice())
                .ticketsForSale(eventRequest.getTicketsForSale())
                .locationId(eventRequest.getLocationId())
                .date(eventRequest.getDate())
                .build();
    }
}
