package uk.ac.wlv.groupwork.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.LiveTraining;
import uk.ac.wlv.groupwork.service.LiveTrainingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/live-trainings")
public class LiveTrainingController {

    private final LiveTrainingService liveTrainingService;

    public LiveTrainingController(LiveTrainingService liveTrainingService) {
        this.liveTrainingService = liveTrainingService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllLiveTrainings() {
        List<LiveTraining> liveTrainings = liveTrainingService.getAllLiveTrainings();
        if (liveTrainings.isEmpty()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "NO DATA");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } else {
            return ResponseEntity.ok(liveTrainings);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLiveTrainingById(@PathVariable int id) {
        Optional<LiveTraining> liveTraining = liveTrainingService.getLiveTrainingById(id);
        if (liveTraining.isPresent()) {
            return ResponseEntity.ok(liveTraining.get());
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Live Training with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addLiveTraining(@RequestBody LiveTraining liveTraining) {
        LiveTraining addedLiveTraining = liveTrainingService.addLiveTraining(liveTraining);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedLiveTraining);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLiveTraining(@PathVariable int id, @RequestBody LiveTraining liveTraining) {
        if (!liveTrainingService.getLiveTrainingById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Live Training with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        liveTraining.setTrainerId(id);
        LiveTraining updatedLiveTraining = liveTrainingService.updateLiveTraining(liveTraining);
        return ResponseEntity.ok(updatedLiveTraining);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLiveTrainingById(@PathVariable int id) {
        if (!liveTrainingService.getLiveTrainingById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Live Training with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        liveTrainingService.deleteLiveTrainingById(id);
        return ResponseEntity.ok().build();
    }
}

