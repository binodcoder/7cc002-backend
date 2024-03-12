package uk.ac.wlv.groupwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.wlv.groupwork.model.Routine;
import uk.ac.wlv.groupwork.service.RoutineService;

@RestController
@RequestMapping("/routine")
public class RoutineController {

    private final RoutineService routineService;

    @Autowired
    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllRoutines() {
        return routineService.getAllRoutines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRoutineById(@PathVariable int id) {
        return routineService.getRoutineById(id);
    }

    @PostMapping
    public ResponseEntity<Object> addRoutine(@RequestBody Routine routine) {
        return routineService.addRoutine(routine);
    }

    @PutMapping
    public ResponseEntity<Object> updateRoutine(@RequestBody Routine routine) {
        return routineService.updateRoutine(routine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRoutineById(@PathVariable int id) {
        return routineService.deleteRoutineById(id);
    }
}
