package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.Exercise;
import uk.ac.wlv.groupwork.service.ExerciseService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllExercises() {
        List<Exercise> exerciseList = exerciseService.getAllExercises();
        if (exerciseList.isEmpty()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "NO DATA");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } else {
            return ResponseEntity.ok(exerciseList);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getExerciseById(@PathVariable int id) {
        Optional<Exercise> exercise = exerciseService.getExerciseById(id);
        if (exercise.isPresent()) {
            return ResponseEntity.ok(exercise.get());
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Exercise with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addExercise(@RequestBody Exercise exercise) {
        Exercise addedExercise = exerciseService.addExercise(exercise);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedExercise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateExercise(@PathVariable int id, @RequestBody Exercise exercise) {
        if (!exerciseService.getExerciseById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Exercise with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        exercise.setId(id);
        Exercise updatedExercise = exerciseService.updateExercise(exercise);
        return ResponseEntity.ok(updatedExercise);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExerciseById(@PathVariable int id) {
        if (!exerciseService.getExerciseById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Exercise with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        exerciseService.deleteExerciseById(id);
        return ResponseEntity.ok().build();
    }
}
