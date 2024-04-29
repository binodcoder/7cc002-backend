package uk.ac.wlv.groupwork;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.ac.wlv.groupwork.dao.ExerciseRepository;
import uk.ac.wlv.groupwork.model.Exercise;
import uk.ac.wlv.groupwork.service.ExerciseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ExerciseServiceTest {

    @Test
    void testGetAllExercises() {
        // Mock dependencies
        ExerciseRepository exerciseRepository = Mockito.mock(ExerciseRepository.class);
        ExerciseService exerciseService = new ExerciseService(exerciseRepository);

        // Create sample data
        List<Exercise> expectedExercises = new ArrayList<>();
        expectedExercises.add(new Exercise());
        expectedExercises.add(new Exercise());

        // Stub the repository method
        when(exerciseRepository.findAll()).thenReturn(expectedExercises);

        // Call the service method
        List<Exercise> result = exerciseService.getAllExercises();

        // Verify the repository method is called
        verify(exerciseRepository).findAll();

        // Assert the result
        assertEquals(expectedExercises, result);
    }

    @Test
    void testGetExerciseById() {
        // Mock dependencies
        ExerciseRepository exerciseRepository = Mockito.mock(ExerciseRepository.class);
        ExerciseService exerciseService = new ExerciseService(exerciseRepository);

        // Create sample data
        int exerciseId = 1;
        Optional<Exercise> expectedExercise = Optional.of(new Exercise());

        // Stub the repository method
        when(exerciseRepository.findById(eq(exerciseId))).thenReturn(expectedExercise);

        // Call the service method
        Optional<Exercise> result = exerciseService.getExerciseById(exerciseId);

        // Verify the repository method is called
        verify(exerciseRepository).findById(eq(exerciseId));

        // Assert the result
        assertEquals(expectedExercise, result);
    }

    @Test
    void testAddExercise() {
        // Mock dependencies
        ExerciseRepository exerciseRepository = Mockito.mock(ExerciseRepository.class);
        ExerciseService exerciseService = new ExerciseService(exerciseRepository);

        // Create sample data
        Exercise exercise = new Exercise();
        Exercise savedExercise = new Exercise();

        // Stub the repository method
        when(exerciseRepository.save(exercise)).thenReturn(savedExercise);

        // Call the service method
        Exercise result = exerciseService.addExercise(exercise);

        // Verify the repository method is called
        verify(exerciseRepository).save(exercise);

        // Assert the result
        assertEquals(savedExercise, result);
    }

    @Test
    void testUpdateExercise() {
        // Mock dependencies
        ExerciseRepository exerciseRepository = Mockito.mock(ExerciseRepository.class);
        ExerciseService exerciseService = new ExerciseService(exerciseRepository);

        // Create sample data
        Exercise exercise = new Exercise();
        Exercise updatedExercise = new Exercise();

        // Stub the repository method
        when(exerciseRepository.save(exercise)).thenReturn(updatedExercise);

        // Call the service method
        Exercise result = exerciseService.updateExercise(exercise);

        // Verify the repository method is called
        verify(exerciseRepository).save(exercise);

        // Assert the result
        assertEquals(updatedExercise, result);
    }

    @Test
    void testDeleteExerciseById() {
        // Mock dependencies
        ExerciseRepository exerciseRepository = Mockito.mock(ExerciseRepository.class);
        ExerciseService exerciseService = new ExerciseService(exerciseRepository);

        // Create sample data
        int exerciseId = 1;

        // Call the service method
        exerciseService.deleteExerciseById(exerciseId);

        // Verify the repository method is called
        verify(exerciseRepository).deleteById(eq(exerciseId));
    }
}
