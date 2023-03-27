package com.orcohen.eventsservice.repository;

import com.orcohen.eventsservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
