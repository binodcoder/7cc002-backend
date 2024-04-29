package uk.ac.wlv.groupwork;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.ac.wlv.groupwork.dao.RoutineRepository;
import uk.ac.wlv.groupwork.model.Routine;
import uk.ac.wlv.groupwork.service.RoutineService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RoutineServiceTest {

    @Test
    void testGetAllRoutines() {
        // Mock dependencies
        RoutineRepository routineRepository = Mockito.mock(RoutineRepository.class);
        RoutineService routineService = new RoutineService(routineRepository);

        // Create sample data
        List<Routine> expectedRoutines = new ArrayList<>();
        expectedRoutines.add(new Routine());
        expectedRoutines.add(new Routine());

        // Stub the repository method
        when(routineRepository.findAll()).thenReturn(expectedRoutines);

        // Call the service method
        List<Routine> result = routineService.getAllRoutines();

        // Verify the repository method is called
        verify(routineRepository).findAll();

        // Assert the result
        assertEquals(expectedRoutines, result);
    }

    @Test
    void testGetRoutineById() {
        // Mock dependencies
        RoutineRepository routineRepository = Mockito.mock(RoutineRepository.class);
        RoutineService routineService = new RoutineService(routineRepository);

        // Create sample data
        int routineId = 1;
        Optional<Routine> expectedRoutine = Optional.of(new Routine());

        // Stub the repository method
        when(routineRepository.findById(eq(routineId))).thenReturn(expectedRoutine);

        // Call the service method
        Optional<Routine> result = routineService.getRoutineById(routineId);

        // Verify the repository method is called
        verify(routineRepository).findById(eq(routineId));

        // Assert the result
        assertEquals(expectedRoutine, result);
    }

    @Test
    void testAddRoutine() {
        // Mock dependencies
        RoutineRepository routineRepository = Mockito.mock(RoutineRepository.class);
        RoutineService routineService = new RoutineService(routineRepository);

        // Create sample data
        Routine routine = new Routine();
        Routine savedRoutine = new Routine();

        // Stub the repository method
        when(routineRepository.save(routine)).thenReturn(savedRoutine);

        // Call the service method
        Routine result = routineService.addRoutine(routine);

        // Verify the repository method is called
        verify(routineRepository).save(routine);

        // Assert the result
        assertEquals(savedRoutine, result);
    }

    @Test
    void testUpdateRoutine() {
        // Mock dependencies
        RoutineRepository routineRepository = Mockito.mock(RoutineRepository.class);
        RoutineService routineService = new RoutineService(routineRepository);

        // Create sample data
        Routine routine = new Routine();
        Routine updatedRoutine = new Routine();

        // Stub the repository method
        when(routineRepository.save(routine)).thenReturn(updatedRoutine);

        // Call the service method
        Routine result = routineService.updateRoutine(routine);

        // Verify the repository method is called
        verify(routineRepository).save(routine);

        // Assert the result
        assertEquals(updatedRoutine, result);
    }

    @Test
    void testDeleteRoutineById() {
        // Mock dependencies
        RoutineRepository routineRepository = Mockito.mock(RoutineRepository.class);
        RoutineService routineService = new RoutineService(routineRepository);

        // Create sample data
        int routineId = 1;

        // Call the service method
        routineService.deleteRoutineById(routineId);

        // Verify the repository method is called
        verify(routineRepository).deleteById(eq(routineId));
    }
}
