package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.OutdoorActivity;
import uk.ac.wlv.groupwork.service.OutdoorActivityService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/outdoor-activities")
public class OutdoorActivityController {

    private final OutdoorActivityService outdoorActivityService;

    @Autowired
    public OutdoorActivityController(OutdoorActivityService outdoorActivityService) {
        this.outdoorActivityService = outdoorActivityService;
    }

    @GetMapping
    public List<OutdoorActivity> getAllOutdoorActivities() {
        return outdoorActivityService.getAllOutdoorActivities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOutdoorActivityById(@PathVariable int id) {
        Optional<OutdoorActivity> outdoorActivity = outdoorActivityService.getOutdoorActivityById(id);
        if (outdoorActivity.isPresent()) {
            return ResponseEntity.ok(outdoorActivity.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Outdoor activity with ID " + id + " not found");
        }
    }

    @PostMapping
    public OutdoorActivity addOutdoorActivity(@RequestBody OutdoorActivity outdoorActivity) {
        return outdoorActivityService.addOutdoorActivity(outdoorActivity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOutdoorActivity(@PathVariable int id, @RequestBody OutdoorActivity outdoorActivity) {
        Optional<OutdoorActivity> existingOutdoorActivity = outdoorActivityService.getOutdoorActivityById(id);
        if (existingOutdoorActivity.isPresent()) {
            outdoorActivity.setId(id);
            return ResponseEntity.ok(outdoorActivityService.updateOutdoorActivity(outdoorActivity));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Outdoor activity with ID " + id + " not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOutdoorActivityById(@PathVariable int id) {
        Optional<OutdoorActivity> existingOutdoorActivity = outdoorActivityService.getOutdoorActivityById(id);
        if (existingOutdoorActivity.isPresent()) {
            outdoorActivityService.deleteOutdoorActivityById(id);
            return ResponseEntity.ok("Outdoor activity with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Outdoor activity with ID " + id + " not found");
        }
    }
}
