package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.Coach;
import uk.ac.wlv.groupwork.service.CoachService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/coach")
public class CoachController {

    private final CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllCoaches() {
        List<Coach> coaches = coachService.getAllCoaches();
        if (coaches.isEmpty()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "NO DATA");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } else {
            return ResponseEntity.ok(coaches);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCoachById(@PathVariable int id) {
        Optional<Coach> coach = coachService.getCoachById(id);
        if (coach.isPresent()) {
            return ResponseEntity.ok(coach.get());
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Coach with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addCoach(@RequestBody Coach coach) {
        Coach addedCoach = coachService.addCoach(coach);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCoach);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCoach(@PathVariable int id, @RequestBody Coach coach) {
        if (!coachService.getCoachById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Coach with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        coach.setId(id);
        Coach updatedCoach = coachService.updateCoach(coach);
        return ResponseEntity.ok(updatedCoach);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCoachById(@PathVariable int id) {
        if (!coachService.getCoachById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Coach with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        coachService.deleteCoachById(id);
        return ResponseEntity.ok().build();
    }
}
