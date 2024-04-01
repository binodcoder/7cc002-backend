package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.RoutineExercise;
import uk.ac.wlv.groupwork.model.RoutineExerciseId;
import uk.ac.wlv.groupwork.service.RoutineExerciseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/routine-exercises")
public class RoutineExerciseController {

    private final RoutineExerciseService routineExerciseService;

    @Autowired
    public RoutineExerciseController(RoutineExerciseService routineExerciseService) {
        this.routineExerciseService = routineExerciseService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllRoutineExercises() {
        List<RoutineExercise> routineExerciseList = routineExerciseService.getAllRoutineExercises();
        if (routineExerciseList.isEmpty()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "NO DATA");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } else {
            return ResponseEntity.ok(routineExerciseList);
        }
    }

    @GetMapping("/{routineId}/{exerciseId}")
    public ResponseEntity<Object> getRoutineExerciseById(@PathVariable int routineId, @PathVariable int exerciseId) {
        RoutineExerciseId id = new RoutineExerciseId(routineId, exerciseId);
        Optional<RoutineExercise> routineExercise = routineExerciseService.getRoutineExerciseById(id);
        if (routineExercise.isPresent()) {
            return ResponseEntity.ok(routineExercise.get());
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Routine Exercise with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addRoutineExercise(
            @RequestParam("exercise_id") int exercise_id,
            @RequestParam("routine_id") int routine_id) {
        //RoutineExercise addedRoutineExercise = routineExerciseService.addRoutineExercise(routineExercise);
        String result = routineExerciseService.addRoutineExercise(exercise_id, routine_id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{routineId}/{exerciseId}")
    public ResponseEntity<Object> updateRoutineExercise(@PathVariable int routineId, @PathVariable int exerciseId, @RequestBody RoutineExercise routineExercise) {
        RoutineExerciseId id = new RoutineExerciseId(routineId, exerciseId);
        if (!routineExerciseService.getRoutineExerciseById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Routine Exercise with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        routineExercise.setId(id);
        RoutineExercise updatedRoutineExercise = routineExerciseService.updateRoutineExercise(routineExercise);
        return ResponseEntity.ok(updatedRoutineExercise);
    }

    @DeleteMapping("/{routineId}/remove/{exerciseId}")
    public ResponseEntity<Object> deleteRoutineExerciseById(@PathVariable int routineId, @PathVariable int exerciseId) {
        RoutineExerciseId id = new RoutineExerciseId(routineId, exerciseId);
        if (!routineExerciseService.getRoutineExerciseById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Routine Exercise with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        routineExerciseService.deleteRoutineExerciseById(id);
        return ResponseEntity.ok().build();
    }
}
