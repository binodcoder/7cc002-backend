package uk.ac.wlv.groupwork.service;

import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.ExerciseRepository;
import uk.ac.wlv.groupwork.dao.RoutineExerciseRepository;
import uk.ac.wlv.groupwork.dao.RoutineRepository;
import uk.ac.wlv.groupwork.model.Exercise;
import uk.ac.wlv.groupwork.model.Routine;
import uk.ac.wlv.groupwork.model.RoutineExercise;
import uk.ac.wlv.groupwork.model.RoutineExerciseId;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoutineExerciseService {

    private final ExerciseRepository exerciseRepository;

    private final RoutineRepository routineRepository;

    private final RoutineExerciseRepository routineExerciseRepository;

    public RoutineExerciseService(ExerciseRepository exerciseRepository, RoutineRepository routineRepository, RoutineExerciseRepository routineExerciseRepository) {
        this.exerciseRepository = exerciseRepository;
        this.routineRepository = routineRepository;
        this.routineExerciseRepository = routineExerciseRepository;
    }

    public List<RoutineExercise> getAllRoutineExercises() {
        return routineExerciseRepository.findAll();
    }

    public Optional<RoutineExercise> getRoutineExerciseById(RoutineExerciseId id) {
        return routineExerciseRepository.findById(id);
    }

    @Transactional
    public String addRoutineExercise(int exerciseId, int routineId) {
        // Retrieve the Exercise and walk Routine from the database.
        Exercise exercise = exerciseRepository.getById(exerciseId);
        Routine routine = routineRepository.getById(routineId);

        if (exercise == null || routine == null) {
            return "Exercise or routine not found";
        }

        //Uses the custom method for this using native SQL.
        //This could not be done with JPQL
        routineRepository.addExerciseToRoutine(exercise, routine);
        return  "Exercise added to the routine successfully";
    }

    public RoutineExercise updateRoutineExercise(RoutineExercise routineExercise) {
        return routineExerciseRepository.save(routineExercise);
    }

    public void deleteRoutineExerciseById(RoutineExerciseId id) {
        routineExerciseRepository.deleteById(id);
    }
}
