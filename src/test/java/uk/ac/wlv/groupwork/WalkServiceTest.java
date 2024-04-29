package uk.ac.wlv.groupwork;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.ac.wlv.groupwork.dao.WalkRepository;
import uk.ac.wlv.groupwork.model.Walk;
import uk.ac.wlv.groupwork.service.WalkService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WalkServiceTest {

    @Mock
    private WalkRepository walkRepository;

    @InjectMocks
    private WalkService walkService;

    @Test
    void testGetAllWalks() {
        // Define test data
        Walk walk1 = new Walk();
        Walk walk2 = new Walk();
        List<Walk> walks = Arrays.asList(walk1, walk2);

        // Stub the repository method
        when(walkRepository.findAll()).thenReturn(walks);

        // Call the service method
        List<Walk> result = walkService.getAllWalks();

        // Verify the result
        assertEquals(2, result.size());
    }

    @Test
    void testGetWalkById() {
        // Define test data
        int walkId = 1;
        Walk walk = new Walk();
        walk.setId(walkId);

        // Stub the repository method
        when(walkRepository.findById(walkId)).thenReturn(Optional.of(walk));

        // Call the service method
        Optional<Walk> result = walkService.getWalkById(walkId);

        // Verify the result
        assertTrue(result.isPresent());
        assertEquals(walkId, result.get().getId());
    }


    @Test
    void testAddWalk() {
        // Mock dependencies
        WalkRepository walkRepository = Mockito.mock(WalkRepository.class);
        WalkService walkService = new WalkService(walkRepository);

        // Create a sample walk
        Walk walk = new Walk();
        walk.setId(1);

        // Stub the repository method
        when(walkRepository.save(walk)).thenReturn(walk);

        // Call the service method
        Walk result = walkService.addWalk(walk);

        // Verify the repository method is called
        verify(walkRepository).save(walk);

        // Assert the result
        assertEquals(walk, result);
    }

    @Test
    void testUpdateWalk() {
        // Mock dependencies
        WalkRepository walkRepository = Mockito.mock(WalkRepository.class);
        WalkService walkService = new WalkService(walkRepository);

        // Create a sample walk
        Walk walk = new Walk();
        walk.setId(1);

        // Stub the repository method
        when(walkRepository.save(walk)).thenReturn(walk);

        // Call the service method
        Walk result = walkService.updateWalk(walk);

        // Verify the repository method is called
        verify(walkRepository).save(walk);

        // Assert the result
        assertEquals(walk, result);
    }

    @Test
    void testDeleteWalkById() {
        // Mock dependencies
        WalkRepository walkRepository = Mockito.mock(WalkRepository.class);
        WalkService walkService = new WalkService(walkRepository);

        // Create a sample walk ID
        int walkId = 1;

        // Call the service method
        walkService.deleteWalkById(walkId);

        // Verify the repository method is called with the correct ID
        verify(walkRepository).deleteById(eq(walkId));
    }

}
