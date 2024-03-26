package uk.ac.wlv.groupwork.service;

import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.RoutineExerciseRepository;
import uk.ac.wlv.groupwork.model.RoutineExercise;
import uk.ac.wlv.groupwork.model.RoutineExerciseId;

import java.util.List;
import java.util.Optional;

@Service
public class RoutineExerciseService {

    private final RoutineExerciseRepository routineExerciseRepository;

    public RoutineExerciseService(RoutineExerciseRepository routineExerciseRepository) {
        this.routineExerciseRepository = routineExerciseRepository;
    }

    public List<RoutineExercise> getAllRoutineExercises() {
        return routineExerciseRepository.findAll();
    }

    public Optional<RoutineExercise> getRoutineExerciseById(RoutineExerciseId id) {
        return routineExerciseRepository.findById(id);
    }

    public RoutineExercise addRoutineExercise(RoutineExercise routineExercise) {
        return routineExerciseRepository.save(routineExercise);
    }

    public RoutineExercise updateRoutineExercise(RoutineExercise routineExercise) {
        return routineExerciseRepository.save(routineExercise);
    }

    public void deleteRoutineExerciseById(RoutineExerciseId id) {
        routineExerciseRepository.deleteById(id);
    }
}
