package uk.ac.wlv.groupwork;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.ac.wlv.groupwork.dao.LiveTrainingRepository;
import uk.ac.wlv.groupwork.model.LiveTraining;
import uk.ac.wlv.groupwork.service.LiveTrainingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LiveTrainingServiceTest {

    @Test
    void testGetAllLiveTrainings() {
        // Mock dependencies
        LiveTrainingRepository liveTrainingRepository = Mockito.mock(LiveTrainingRepository.class);
        LiveTrainingService liveTrainingService = new LiveTrainingService(liveTrainingRepository);

        // Create sample data
        List<LiveTraining> expectedLiveTrainings = new ArrayList<>();
        expectedLiveTrainings.add(new LiveTraining());
        expectedLiveTrainings.add(new LiveTraining());

        // Stub the repository method
        when(liveTrainingRepository.findAll()).thenReturn(expectedLiveTrainings);

        // Call the service method
        List<LiveTraining> result = liveTrainingService.getAllLiveTrainings();

        // Verify the repository method is called
        verify(liveTrainingRepository).findAll();

        // Assert the result
        assertEquals(expectedLiveTrainings, result);
    }

    @Test
    void testGetLiveTrainingById() {
        // Mock dependencies
        LiveTrainingRepository liveTrainingRepository = Mockito.mock(LiveTrainingRepository.class);
        LiveTrainingService liveTrainingService = new LiveTrainingService(liveTrainingRepository);

        // Create sample data
        int liveTrainingId = 1;
        Optional<LiveTraining> expectedLiveTraining = Optional.of(new LiveTraining());

        // Stub the repository method
        when(liveTrainingRepository.findById(eq(liveTrainingId))).thenReturn(expectedLiveTraining);

        // Call the service method
        Optional<LiveTraining> result = liveTrainingService.getLiveTrainingById(liveTrainingId);

        // Verify the repository method is called
        verify(liveTrainingRepository).findById(eq(liveTrainingId));

        // Assert the result
        assertEquals(expectedLiveTraining, result);
    }

    @Test
    void testAddLiveTraining() {
        // Mock dependencies
        LiveTrainingRepository liveTrainingRepository = Mockito.mock(LiveTrainingRepository.class);
        LiveTrainingService liveTrainingService = new LiveTrainingService(liveTrainingRepository);

        // Create sample data
        LiveTraining liveTraining = new LiveTraining();
        LiveTraining savedLiveTraining = new LiveTraining();

        // Stub the repository method
        when(liveTrainingRepository.save(liveTraining)).thenReturn(savedLiveTraining);

        // Call the service method
        LiveTraining result = liveTrainingService.addLiveTraining(liveTraining);

        // Verify the repository method is called
        verify(liveTrainingRepository).save(liveTraining);

        // Assert the result
        assertEquals(savedLiveTraining, result);
    }

    @Test
    void testUpdateLiveTraining() {
        // Mock dependencies
        LiveTrainingRepository liveTrainingRepository = Mockito.mock(LiveTrainingRepository.class);
        LiveTrainingService liveTrainingService = new LiveTrainingService(liveTrainingRepository);

        // Create sample data
        LiveTraining liveTraining = new LiveTraining();
        LiveTraining updatedLiveTraining = new LiveTraining();

        // Stub the repository method
        when(liveTrainingRepository.save(liveTraining)).thenReturn(updatedLiveTraining);

        // Call the service method
        LiveTraining result = liveTrainingService.updateLiveTraining(liveTraining);

        // Verify the repository method is called
        verify(liveTrainingRepository).save(liveTraining);

        // Assert the result
        assertEquals(updatedLiveTraining, result);
    }

    @Test
    void testDeleteLiveTrainingById() {
        // Mock dependencies
        LiveTrainingRepository liveTrainingRepository = Mockito.mock(LiveTrainingRepository.class);
        LiveTrainingService liveTrainingService = new LiveTrainingService(liveTrainingRepository);

        // Create sample data
        int liveTrainingId = 1;

        // Call the service method
        liveTrainingService.deleteLiveTrainingById(liveTrainingId);

        // Verify the repository method is called
        verify(liveTrainingRepository).deleteById(eq(liveTrainingId));
    }
}
