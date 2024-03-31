package uk.ac.wlv.groupwork.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.WalkMedia;
import uk.ac.wlv.groupwork.service.WalkMediaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/walk-media")
public class WalkMediaController {

    private final WalkMediaService walkMediaService;

    public WalkMediaController(WalkMediaService walkMediaService) {
        this.walkMediaService = walkMediaService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllWalkMedia() {
        List<WalkMedia> walkMediaList = walkMediaService.getAllWalkMedia();
        if (walkMediaList.isEmpty()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "NO DATA");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } else {
            return ResponseEntity.ok(walkMediaList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getWalkMediaById(@PathVariable int id) {
        Optional<WalkMedia> walkMedia = walkMediaService.getWalkMediaById(id);
        if (walkMedia.isPresent()) {
            return ResponseEntity.ok(walkMedia.get());
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Walk Media with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping("/walk-id/{walkId}")
    public ResponseEntity<Object> getWalkMediaByWalkId(@PathVariable int walkId) {
        List<WalkMedia> walkMediaList = walkMediaService.getWalkMediaByWalkId(walkId);
        if (!walkMediaList.isEmpty()) {
            return ResponseEntity.ok(walkMediaList);
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Walk Media(s) with Walk ID " + walkId + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addWalkMedia(@RequestBody WalkMedia walkMedia) {
        WalkMedia addedWalkMedia = walkMediaService.addWalkMedia(walkMedia);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedWalkMedia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateWalkMedia(@PathVariable int id, @RequestBody WalkMedia walkMedia) {
        if (!walkMediaService.getWalkMediaById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Walk Media with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        walkMedia.setId(id);
        WalkMedia updatedWalkMedia = walkMediaService.updateWalkMedia(walkMedia);
        return ResponseEntity.ok(updatedWalkMedia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWalkMediaById(@PathVariable int id) {
        if (!walkMediaService.getWalkMediaById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Walk Media with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        walkMediaService.deleteWalkMediaById(id);
        return ResponseEntity.ok().build();
    }
}
