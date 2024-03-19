package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.Event;
import uk.ac.wlv.groupwork.service.EventService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        if (events.isEmpty()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "NO DATA");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } else {
            return ResponseEntity.ok(events);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEventById(@PathVariable int id) {
        Optional<Event> event = eventService.getEventById(id);
        if (event.isPresent()) {
            return ResponseEntity.ok(event.get());
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Event with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addEvent(@RequestBody Event event) {
        Event addedEvent = eventService.addEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEvent(@PathVariable int id, @RequestBody Event event) {
        if (!eventService.getEventById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Event with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        event.setEventId(id);
        Event updatedEvent = eventService.updateEvent(event);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEventById(@PathVariable int id) {
        if (!eventService.getEventById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Event with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        eventService.deleteEventById(id);
        return ResponseEntity.ok().build();
    }
}
