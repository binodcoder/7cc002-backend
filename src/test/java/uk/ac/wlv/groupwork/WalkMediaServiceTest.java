package uk.ac.wlv.groupwork;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.ac.wlv.groupwork.dao.WalkMediaRepository;
import uk.ac.wlv.groupwork.model.WalkMedia;
import uk.ac.wlv.groupwork.service.WalkMediaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class WalkMediaServiceTest {

    @Mock
    private WalkMediaRepository walkMediaRepository;

    @InjectMocks
    private WalkMediaService walkMediaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllWalkMedia() {
        // Create sample data
        List<WalkMedia> expectedWalkMediaList = new ArrayList<>();
        // Add sample WalkMedia objects to the list...

        // Mock the repository method
        when(walkMediaRepository.findAll()).thenReturn(expectedWalkMediaList);

        // Call the service method
        List<WalkMedia> actualWalkMediaList = walkMediaService.getAllWalkMedia();

        // Verify the result
        assertEquals(expectedWalkMediaList, actualWalkMediaList);
    }

    @Test
    void testGetWalkMediaById() {
        // Create a sample WalkMedia object
        WalkMedia expectedWalkMedia = new WalkMedia();
        // Set properties of the WalkMedia object...

        // Mock the repository method
        when(walkMediaRepository.findById(anyInt())).thenReturn(Optional.of(expectedWalkMedia));

        // Call the service method
        Optional<WalkMedia> actualWalkMediaOptional = walkMediaService.getWalkMediaById(1);

        // Verify the result
        assertEquals(Optional.of(expectedWalkMedia), actualWalkMediaOptional);
    }

    @Test
    void testGetWalkMediaByWalkId() {
        // Create sample data
        List<WalkMedia> expectedWalkMediaList = new ArrayList<>();
        // Add sample WalkMedia objects to the list...

        // Mock the repository method
        when(walkMediaRepository.getWalkMediaByWalkId(anyInt())).thenReturn(expectedWalkMediaList);

        // Call the service method
        List<WalkMedia> actualWalkMediaList = walkMediaService.getWalkMediaByWalkId(1);

        // Verify the result
        assertEquals(expectedWalkMediaList, actualWalkMediaList);
    }

    @Test
    void testAddWalkMedia() {
        // Create a sample WalkMedia object
        WalkMedia expectedWalkMedia = new WalkMedia();
        // Set properties of the WalkMedia object...

        // Mock the repository method
        when(walkMediaRepository.save(expectedWalkMedia)).thenReturn(expectedWalkMedia);

        // Call the service method
        WalkMedia actualWalkMedia = walkMediaService.addWalkMedia(expectedWalkMedia);

        // Verify the result
        assertEquals(expectedWalkMedia, actualWalkMedia);
    }

    @Test
    void testUpdateWalkMedia() {
        // Create a sample WalkMedia object
        WalkMedia expectedWalkMedia = new WalkMedia();
        // Set properties of the WalkMedia object...

        // Mock the repository method
        when(walkMediaRepository.save(expectedWalkMedia)).thenReturn(expectedWalkMedia);

        // Call the service method
        WalkMedia actualWalkMedia = walkMediaService.updateWalkMedia(expectedWalkMedia);

        // Verify the result
        assertEquals(expectedWalkMedia, actualWalkMedia);
    }

    @Test
    void testDeleteWalkMediaById() {
        // Call the service method
        walkMediaService.deleteWalkMediaById(1);

        // Verify that the repository method was called with the correct argument
        verify(walkMediaRepository, times(1)).deleteById(1);
    }
}

