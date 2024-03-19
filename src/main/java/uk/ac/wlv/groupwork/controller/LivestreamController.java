package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.Livestream;
import uk.ac.wlv.groupwork.service.LivestreamService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livestreams")
public class LivestreamController {

    private final LivestreamService livestreamService;

    public LivestreamController(LivestreamService livestreamService) {
        this.livestreamService = livestreamService;
    }

    @GetMapping
    public List<Livestream> getAllLivestreams() {
        return livestreamService.getAllLivestreams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLivestreamById(@PathVariable int id) {
        Optional<Livestream> livestream = livestreamService.getLivestreamById(id);
        if (livestream.isPresent()) {
            return ResponseEntity.ok(livestream.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livestream with ID " + id + " not found");
        }
    }

    @PostMapping
    public Livestream addLivestream(@RequestBody Livestream livestream) {
        return livestreamService.addLivestream(livestream);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLivestream(@PathVariable int id, @RequestBody Livestream livestream) {
        Optional<Livestream> existingLivestream = livestreamService.getLivestreamById(id);
        if (existingLivestream.isPresent()) {
            livestream.setId(id);
            return ResponseEntity.ok(livestreamService.updateLivestream(livestream));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livestream with ID " + id + " not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLivestreamById(@PathVariable int id) {
        Optional<Livestream> existingLivestream = livestreamService.getLivestreamById(id);
        if (existingLivestream.isPresent()) {
            livestreamService.deleteLivestreamById(id);
            return ResponseEntity.ok("Livestream with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livestream with ID " + id + " not found");
        }
    }
}
