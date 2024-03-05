package uk.ac.wlv.groupwork.service;

import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.EventRepository;
import uk.ac.wlv.groupwork.model.Event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Object getAllEvents() {
        try {
            List<Event> events = eventRepository.findAll();
            if (events.isEmpty()) {
                Map<String, String> errorMessage = new HashMap<>();
                errorMessage.put("EMPTY", "No Data");
                return errorMessage;
            } else {
                return events;
            }
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "Database error: " + e.getMessage());
            return errorMessage;
        }
    }

}

