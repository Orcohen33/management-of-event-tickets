package com.orcohen.eventsservice.exceptions;

public class EventNotFoundException extends Throwable {
    public EventNotFoundException(String message) {
        super(message);
    }
}
