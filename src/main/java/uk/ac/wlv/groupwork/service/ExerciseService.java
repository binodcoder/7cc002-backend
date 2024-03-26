package uk.ac.wlv.groupwork.service;

import org.springframework.stereotype.Service;
import uk.ac.wlv.groupwork.dao.ExerciseRepository;
import uk.ac.wlv.groupwork.model.Exercise;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Optional<Exercise> getExerciseById(int id) {
        return exerciseRepository.findById(id);
    }

    public Exercise addExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public Exercise updateExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public void deleteExerciseById(int id) {
        exerciseRepository.deleteById(id);
    }
}
