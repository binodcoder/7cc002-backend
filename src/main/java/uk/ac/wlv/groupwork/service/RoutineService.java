package uk.ac.wlv.groupwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.RoutineRepository;
import uk.ac.wlv.groupwork.model.Routine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RoutineService {

    private final RoutineRepository routineRepository;

    @Autowired
    public RoutineService(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }

    public ResponseEntity<Object> getAllRoutines() {
        try {
            List<Routine> routines = routineRepository.findAll();
            if (routines.isEmpty()) {
                Map<String, String> errorMessage = new HashMap<>();
                errorMessage.put("EMPTY", "NO DATA");
                return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(routines, HttpStatus.OK);
            }
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("DB ERROR", "ERROR " + e.getMessage());
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getRoutineById(int id) {
        try {
            Optional<Routine> routine = routineRepository.findById(id);
            if (routine.isPresent()) {
                return ResponseEntity.ok(routine.get());
            } else {
                Map<String, String> errorMessage = new HashMap<>();
                errorMessage.put("NOT FOUND", "Routine with ID " + id + " not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("ERROR", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }


    public ResponseEntity<Object> addRoutine(Routine routine) {
        try {
            Routine addedRoutine = routineRepository.save(routine);
            return new ResponseEntity<>(addedRoutine, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("DB ERROR", "ERROR " + e.getMessage());
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> updateRoutine(Routine routine) {
        try {
            if (routineRepository.existsById(routine.getId())) {
                Routine updatedRoutine = routineRepository.save(routine);
                return new ResponseEntity<>(updatedRoutine, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Routine not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("DB ERROR", "ERROR " + e.getMessage());
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> deleteRoutineById(int id) {
        try {
            if (routineRepository.existsById(id)) {
                routineRepository.deleteById(id);
                return new ResponseEntity<>("Routine deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Routine not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            Map<String, String> errorMessage = new HashMap<>();
            errorMessage.put("DB ERROR", "ERROR " + e.getMessage());
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
