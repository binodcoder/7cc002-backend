package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.ActivityContent;
import uk.ac.wlv.groupwork.service.ActivityContentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activity-contents")
public class ActivityContentController {

    private final ActivityContentService activityContentService;

    public ActivityContentController(ActivityContentService activityContentService) {
        this.activityContentService = activityContentService;
    }

    @GetMapping
    public List<ActivityContent> getAllActivityContents() {
        return activityContentService.getAllActivityContents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getActivityContentById(@PathVariable int id) {
        Optional<ActivityContent> activityContent = activityContentService.getActivityContentById(id);
        if (activityContent.isPresent()) {
            return ResponseEntity.ok(activityContent.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ActivityContent with ID " + id + " not found");
        }
    }

    @PostMapping
    public ActivityContent addActivityContent(@RequestBody ActivityContent activityContent) {
        return activityContentService.addActivityContent(activityContent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateActivityContent(@PathVariable int id, @RequestBody ActivityContent activityContent) {
        Optional<ActivityContent> existingActivityContent = activityContentService.getActivityContentById(id);
        if (existingActivityContent.isPresent()) {
            activityContent.setContentId(id);
            return ResponseEntity.ok(activityContentService.updateActivityContent(activityContent));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ActivityContent with ID " + id + " not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteActivityContentById(@PathVariable int id) {
        Optional<ActivityContent> existingActivityContent = activityContentService.getActivityContentById(id);
        if (existingActivityContent.isPresent()) {
            activityContentService.deleteActivityContentById(id);
            return ResponseEntity.ok("ActivityContent with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ActivityContent with ID " + id + " not found");
        }
    }
}
