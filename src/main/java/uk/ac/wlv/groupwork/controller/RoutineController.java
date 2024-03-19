package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.Routine;
import uk.ac.wlv.groupwork.service.RoutineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/routine")
public class RoutineController {

    private final RoutineService routineService;

    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllRoutines() {
        List<Routine> routines = routineService.getAllRoutines();
        if (routines.isEmpty()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", "NO DATA");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } else {
            return ResponseEntity.ok(routines);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRoutineById(@PathVariable int id) {
        Optional<Routine> routine = routineService.getRoutineById(id);
        if (routine.isPresent()) {
            return ResponseEntity.ok(routine.get());
        } else {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Routine with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addRoutine(@RequestBody Routine routine) {
        Routine addedRoutine = routineService.addRoutine(routine);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedRoutine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRoutine(@PathVariable int id, @RequestBody Routine routine) {
        if (!routineService.getRoutineById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Routine with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        routine.setId(id);
        Routine updatedRoutine = routineService.updateRoutine(routine);
        return ResponseEntity.ok(updatedRoutine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRoutineById(@PathVariable int id) {
        if (!routineService.getRoutineById(id).isPresent()) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("NOT FOUND", "Routine with ID " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
        routineService.deleteRoutineById(id);
        return ResponseEntity.ok().build();
    }
}
