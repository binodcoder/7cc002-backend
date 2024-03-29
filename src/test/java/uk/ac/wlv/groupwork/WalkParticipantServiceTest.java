package uk.ac.wlv.groupwork;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uk.ac.wlv.groupwork.dao.UserRepository;
import uk.ac.wlv.groupwork.dao.WalkParticipantRepository;
import uk.ac.wlv.groupwork.dao.WalkRepository;
import uk.ac.wlv.groupwork.model.User;
import uk.ac.wlv.groupwork.model.Walk;
import uk.ac.wlv.groupwork.model.WalkParticipant;
import uk.ac.wlv.groupwork.service.WalkParticipantService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WalkParticipantServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private WalkRepository walkRepository;

    @Mock
    private WalkParticipantRepository walkParticipantRepository;

    @InjectMocks
    private WalkParticipantService walkParticipantService;

    public WalkParticipantServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testJoinWalk_Success() {
        // Mock user and walk
        User user = new User();
        user.setId(2);
        Walk walk = new Walk();
        walk.setId(5);

        // Mock repository behavior
        when(userRepository.findById(2)).thenReturn(Optional.of(user));
        when(walkRepository.findById(1)).thenReturn(Optional.of(walk));

        // Perform the operation
        String result = walkParticipantService.joinWalk(1, 1);

        // Verify repository interactions
        verify(walkParticipantRepository, times(1)).save(any(WalkParticipant.class));

        // Verify result
        assertEquals("User joined the walk successfully", result);
    }

    @Test
    public void testJoinWalk_UserNotFound() {
        // Mock walk
        Walk walk = new Walk();
        walk.setId(1);

        // Mock repository behavior (user not found)
        when(userRepository.findById(1)).thenReturn(Optional.empty());
        when(walkRepository.findById(1)).thenReturn(Optional.of(walk));

        // Perform the operation
        String result = walkParticipantService.joinWalk(1, 1);

        // Verify repository interactions
        verify(walkParticipantRepository, never()).save(any(WalkParticipant.class));

        // Verify result
        assertEquals("User or walk not found", result);
    }

    @Test
    public void testJoinWalk_WalkNotFound() {
        // Mock user
        User user = new User();
        user.setId(1);

        // Mock repository behavior (walk not found)
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(walkRepository.findById(1)).thenReturn(Optional.empty());

        // Perform the operation
        String result = walkParticipantService.joinWalk(1, 1);

        // Verify repository interactions
        verify(walkParticipantRepository, never()).save(any(WalkParticipant.class));

        // Verify result
        assertEquals("User or walk not found", result);
    }
}