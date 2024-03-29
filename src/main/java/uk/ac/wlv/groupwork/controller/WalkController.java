package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.Walk;
import uk.ac.wlv.groupwork.service.WalkService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/walks")
public class WalkController {

    private final WalkService walkService;

    public WalkController(WalkService walkService) {
        this.walkService = walkService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllWalks() {
        List<Walk> walks = walkService.getAllWalks();
        if (walks.isEmpty()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "NO DATA");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } else {
            return ResponseEntity.ok(walks);
        }
    }

    @GetMapping("/export")
    public ResponseEntity<List<Walk>> getAllWalksWithParticipants() {
        List<Walk> walks = walkService.getAllWalksWithParticipants();
        return ResponseEntity.ok(walks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getWalkById(@PathVariable int id) {
        Optional<Walk> walk = walkService.getWalkById(id);
        if (walk.isPresent()) {
            return ResponseEntity.ok(walk.get());
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Walk with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addWalk(@RequestBody Walk walk) {
        Walk addedWalk = walkService.addWalk(walk);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedWalk);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateWalk(@PathVariable int id, @RequestBody Walk walk) {
        if (!walkService.getWalkById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Walk with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        walk.setId(id);
        Walk updatedWalk = walkService.updateWalk(walk);
        return ResponseEntity.ok(updatedWalk);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWalkById(@PathVariable int id) {
        if (!walkService.getWalkById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Walk with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        walkService.deleteWalkById(id);
        return ResponseEntity.ok().build();
    }
}
