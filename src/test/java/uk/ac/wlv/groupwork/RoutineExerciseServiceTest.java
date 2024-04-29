package uk.ac.wlv.groupwork;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.ac.wlv.groupwork.dao.ExerciseRepository;
import uk.ac.wlv.groupwork.dao.RoutineExerciseRepository;
import uk.ac.wlv.groupwork.dao.RoutineRepository;
import uk.ac.wlv.groupwork.model.Exercise;
import uk.ac.wlv.groupwork.model.Routine;
import uk.ac.wlv.groupwork.model.RoutineExercise;
import uk.ac.wlv.groupwork.model.RoutineExerciseId;
import uk.ac.wlv.groupwork.service.RoutineExerciseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RoutineExerciseServiceTest {

    @Test
    void testGetAllRoutineExercises() {
        // Mock dependencies
        ExerciseRepository exerciseRepository = Mockito.mock(ExerciseRepository.class);
        RoutineRepository routineRepository = Mockito.mock(RoutineRepository.class);
        RoutineExerciseRepository routineExerciseRepository = Mockito.mock(RoutineExerciseRepository.class);
        RoutineExerciseService routineExerciseService = new RoutineExerciseService(exerciseRepository, routineRepository, routineExerciseRepository);

        // Create sample data
        List<RoutineExercise> expectedRoutineExercises = new ArrayList<>();
        expectedRoutineExercises.add(new RoutineExercise());
        expectedRoutineExercises.add(new RoutineExercise());

        // Stub the repository method
        when(routineExerciseRepository.findAll()).thenReturn(expectedRoutineExercises);

        // Call the service method
        List<RoutineExercise> result = routineExerciseService.getAllRoutineExercises();

        // Verify the repository method is called
        verify(routineExerciseRepository).findAll();

        // Assert the result
        assertEquals(expectedRoutineExercises, result);
    }

    @Test
    void testGetRoutineExerciseById() {
        // Mock dependencies
        ExerciseRepository exerciseRepository = Mockito.mock(ExerciseRepository.class);
        RoutineRepository routineRepository = Mockito.mock(RoutineRepository.class);
        RoutineExerciseRepository routineExerciseRepository = Mockito.mock(RoutineExerciseRepository.class);
        RoutineExerciseService routineExerciseService = new RoutineExerciseService(exerciseRepository, routineRepository, routineExerciseRepository);

        // Create sample data
        RoutineExerciseId routineExerciseId = new RoutineExerciseId();
        Optional<RoutineExercise> expectedRoutineExercise = Optional.of(new RoutineExercise());

        // Stub the repository method
        when(routineExerciseRepository.findById(routineExerciseId)).thenReturn(expectedRoutineExercise);

        // Call the service method
        Optional<RoutineExercise> result = routineExerciseService.getRoutineExerciseById(routineExerciseId);

        // Verify the repository method is called
        verify(routineExerciseRepository).findById(routineExerciseId);

        // Assert the result
        assertEquals(expectedRoutineExercise, result);
    }

    @Test
    void testAddRoutineExercise() {
        // Mock dependencies
        ExerciseRepository exerciseRepository = Mockito.mock(ExerciseRepository.class);
        RoutineRepository routineRepository = Mockito.mock(RoutineRepository.class);
        RoutineExerciseRepository routineExerciseRepository = Mockito.mock(RoutineExerciseRepository.class);
        RoutineExerciseService routineExerciseService = new RoutineExerciseService(exerciseRepository, routineRepository, routineExerciseRepository);

        // Create sample data
        int exerciseId = 1;
        int routineId = 1;
        Exercise exercise = new Exercise();
        Routine routine = new Routine();

        // Stub the repository methods
        when(exerciseRepository.getById(exerciseId)).thenReturn(exercise);
        when(routineRepository.getById(routineId)).thenReturn(routine);

        // Call the service method
        String result = routineExerciseService.addRoutineExercise(exerciseId, routineId);

        // Verify the repository method is called
        verify(routineRepository).addExerciseToRoutine(exercise, routine);

        // Assert the result
        assertEquals("Exercise added to the routine successfully", result);
    }

    @Test
    void testUpdateRoutineExercise() {
        // Mock dependencies
        ExerciseRepository exerciseRepository = Mockito.mock(ExerciseRepository.class);
        RoutineRepository routineRepository = Mockito.mock(RoutineRepository.class);
        RoutineExerciseRepository routineExerciseRepository = Mockito.mock(RoutineExerciseRepository.class);
        RoutineExerciseService routineExerciseService = new RoutineExerciseService(exerciseRepository, routineRepository, routineExerciseRepository);

        // Create sample data
        RoutineExercise routineExercise = new RoutineExercise();

        // Stub the repository method
        when(routineExerciseRepository.save(routineExercise)).thenReturn(routineExercise);

        // Call the service method
        RoutineExercise result = routineExerciseService.updateRoutineExercise(routineExercise);

        // Verify the repository method is called
        verify(routineExerciseRepository).save(routineExercise);

        // Assert the result
        assertEquals(routineExercise, result);
    }

    @Test
    void testDeleteRoutineExerciseById() {
        // Mock dependencies
        ExerciseRepository exerciseRepository = Mockito.mock(ExerciseRepository.class);
        RoutineRepository routineRepository = Mockito.mock(RoutineRepository.class);
        RoutineExerciseRepository routineExerciseRepository = Mockito.mock(RoutineExerciseRepository.class);
        RoutineExerciseService routineExerciseService = new RoutineExerciseService(exerciseRepository, routineRepository, routineExerciseRepository);

        // Create sample data
        RoutineExerciseId routineExerciseId = new RoutineExerciseId();

        // Call the service method
        routineExerciseService.deleteRoutineExerciseById(routineExerciseId);

        // Verify the repository method
        verify(routineExerciseRepository).deleteById(routineExerciseId);
    }

}

